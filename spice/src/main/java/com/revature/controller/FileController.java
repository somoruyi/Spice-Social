package com.revature.controller;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.repository.PostRepository;
import com.revature.services.PostService;
import com.revature.services.S3Service;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private PostService postServ;

	@Autowired
	private S3Service s3service;
	
	private String endpoint;
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		String keyName = file.getOriginalFilename();
		s3service.uploadFile(keyName, file);
		endpoint = "https://spice-sm.s3.us-east-2.amazonaws.com" + "/" + keyName;
		return endpoint;
	}
	
	@GetMapping("/download")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String keyName){
		ByteArrayOutputStream downloadStream = s3service.downloadFile(keyName);
		return ResponseEntity.ok().contentType(contentType(keyName))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + keyName + "\"")
				.body(downloadStream.toByteArray());
	}
	
	
	@GetMapping("/all")
	public List<String> listAllFiles(){
		return s3service.listFiles();
	}
	
	private MediaType contentType(String keyName) {
		String[] arr = keyName.split("\\.");
		String type = arr[arr.length-1];
		switch(type) {
		case "txt": return MediaType.TEXT_PLAIN;
		case "png": return MediaType.IMAGE_PNG;
		case "jpg": return MediaType.IMAGE_JPEG;
		default: return MediaType.APPLICATION_OCTET_STREAM;
		}
	}
}
