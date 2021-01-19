package com.revature.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repository.PostRepository;
import com.revature.services.PostService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/spice")
public class PostController {

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private PostService postServ;

	
	@GetMapping("/post")
	public List<Post> getAllPosts() {
		
		return postRepo.findAll();
	}

	@GetMapping("/post/{post_id}")
	public ResponseEntity<Post> getPostById(@PathVariable(value = "post_id") int post_id)
			throws ResourceNotFoundException {
		Post post = postRepo.findById(post_id)
				.orElseThrow(() -> new ResourceNotFoundException("Post Not Found For This Id :: " + post_id));
		return ResponseEntity.ok().body(post);
	}
//	@CookieValue
	@PostMapping(value="/newpost")

	public Post createPost(@Valid @RequestBody Post post) throws IOException {

		post.getUser().getUserId();
		String test = post.getImage();
		String set = test.substring(1, test.length()-1);
		post.setImage(set);
			

		System.out.println(post);
		
		return postRepo.save(post);
		
	}

	
//	public Post updatePostImage(String endpoint){
//		
//	}

	@PutMapping("/post/{post_id}")
	public ResponseEntity<Post> updatePost(@PathVariable(value = "post_id") int post_id,
			@Valid @RequestBody Post postDetails) throws ResourceNotFoundException {
		Post post = postRepo.findById(post_id)
				.orElseThrow(() -> new ResourceNotFoundException("Post Not Found For This Id :: " + post_id));

		post.setUser(postDetails.getUser());
		post.setPost(postDetails.getPost());
		post.setImage(postDetails.getImage());
		post.setLikeCount(postDetails.getLikeCount());
		final Post updatedPost = postRepo.save(post);
		return ResponseEntity.ok(updatedPost);
	}

	@DeleteMapping("/post/{post_id}")
	public Map<String, Boolean> deletePost(@PathVariable(value = "post_id") int post_id)
			throws ResourceNotFoundException {
		Post post = postRepo.findById(post_id)
				.orElseThrow(() -> new ResourceNotFoundException("Post Not Found For This Id :: " + post_id));

		postRepo.delete(post);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
	
	@PostMapping("/like/{post_id}")
	public void getLikesById(@PathVariable(value = "post_id") int post_id) throws GenericJDBCException{
		postRepo.getLikes(post_id);
		try {
			
		}
		catch(GenericJDBCException e){
			e.getSQLException();
			e.printStackTrace();
		}
		
	}
	
	

}