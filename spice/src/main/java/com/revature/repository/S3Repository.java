package com.revature.repository;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface S3Repository {
	public ByteArrayOutputStream  downloadFile(String keyName);
	public void uploadFile(String keyName, MultipartFile file);
	public List<String> listFiles();
}
