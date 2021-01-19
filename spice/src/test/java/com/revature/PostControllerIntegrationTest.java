package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.amazonaws.services.appconfig.model.Application;
import com.amazonaws.services.appstream.model.User;
import com.revature.models.Post;
import com.revature.repository.PostRepository;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerIntegrationTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}
	
//	@Test
//	public void testGetPostById() {
//		Post post = restTemplate.getForObject(getRootUrl() + "spice/post/", Post.class);
//		System.out.println(post.getPostId());
//		assertNotNull(post);
//	}

	
	@Test
	public void testGetPostId() {
		Post post = new Post();
		post.setPostId(4);
		int actual = 4;
		assertEquals(post.getPostId(), actual);
	}
	@Test
	public void testGetPostImage() {
		Post post = new Post();
		post.setImage("painting");
		String actual = "painting";
		assertEquals(post.getImage(), actual);
	}
	
//	@Test
//	public void testgetAllPosts() {
////		//return postRepo.findAll();
////		PostRepository postRepo;
////		postRepo.;
////		String actual = "jane";
////		assertEquals(, actual);
//	}



}
