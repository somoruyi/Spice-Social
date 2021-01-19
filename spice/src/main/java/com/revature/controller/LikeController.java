package com.revature.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Like;
import com.revature.repository.LikeRepository;
import com.revature.services.LikeService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/like")
public class LikeController {

	//private LikeService likeServ;
	
	@Autowired
	private LikeRepository likeRepo;
	
	@GetMapping("/list")
	public List<Like> getAllLikes(){
		return likeRepo.findAll();
	    }
	
//	@GetMapping("/list/{likeId}")
//	public ResponseEntity<Like> getLikeById(@PathVariable(value = "likeId") int likeId)
//			throws ResourceNotFoundException {
//		Like likeIdObj = likeRepo.findById(likeId)
//				.orElseThrow(() -> new ResourceNotFoundException("Post not found for this likeId :: " + likeId));
//		return ResponseEntity.ok().body(likeIdObj);
//	}
//	
//	@PutMapping("/list/{likeId}")
//	public ResponseEntity<Like> updateEmployee(@PathVariable(value = "likeId") int likeId,
//			@Valid @RequestBody Like employeeDetails) throws ResourceNotFoundException {
//		Like likeIdObj  = likeRepo.findById(likeId)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//		likeIdObj.setEmailId(employeeDetails.getEmailId());
//		likeIdObj.setLastName(employeeDetails.getLastName());
//		likeIdObj.setFirstName(employeeDetails.getFirstName());
//		final Like updatedLikeIdObj = likeRepo.save(likeIdObj);
//		return ResponseEntity.ok(updatedLikeIdObj);
//	}
	
//	@PostMapping("/list")
//	public Like createEmployee(@PathVariable(value = "likeId") int likeId, int userId) {
//		likeIdObj.setPostId(likeIdObj.getPostId());
//		likeIdObj.setUserId(likeIdObj.getUserId());
//		return likeRepo.save(likeIdObj);
//		
//	}
	
	@DeleteMapping("/list/{likeId}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "likeId") int likeId)
			throws ResourceNotFoundException {
		Like likeIdObj = likeRepo.findById(likeId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found for this likeId :: " + likeId));

		likeRepo.delete(likeIdObj);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/list/{likeId}")
	public ResponseEntity<Like> getLikeById(@PathVariable(value = "likeId") int likeId)
			throws ResourceNotFoundException {
		Like likeIdObj = likeRepo.findById(likeId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found for this likeId :: " + likeId));
		return ResponseEntity.ok().body(likeIdObj);
	}
	
	@PostMapping("/likes/{postId}")
	public void getLikesByPostId(@PathVariable(value = "postId") int postId) {
		
	}
	


	
	
}