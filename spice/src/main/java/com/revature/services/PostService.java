package com.revature.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.revature.exceptions.StorageException;
import com.revature.models.Post;
import com.revature.repository.PostRepository;



@Service
public class PostService {
	
private PostRepository pRepo;
	
	@Autowired
	public PostService(PostRepository postRepo) {
		this.pRepo=postRepo;
	}

	
	public Post store(MultipartFile file) throws IOException{
		
		if(file.isEmpty()) {
			throw new StorageException("Failed to store empty file");
		}
		
		
		
		return null;
//				pRepo.save(file);
	}
	
	
	
	
	
	

	
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public List<Post> getAll(){
		return (List<Post>) pRepo.findAll();
	}
	
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public Post getById(int id) {
		Optional<Post> _post=pRepo.findById(id);
		return _post.get();
	}
 

	@Transactional
	//we probably need to add each field ex. newUser.getUserId().equals("")
	public Post add(Post newPost) {
		if(newPost.getPost().equals("")|| newPost.getImage().equals("")) return null;
		if(newPost.getPost()==null|| newPost.getImage()==null) return null;
		return pRepo.save(newPost);
	}
	@Transactional
	public Post update(Post updatedPost ) {
		if(updatedPost.getPost().equals("")|| updatedPost.getImage().equals("")) return null;
		if(updatedPost.getPost()==null|| updatedPost.getImage()==null) return null;
		return pRepo.save(updatedPost);
	}
	
	@Transactional
	public boolean delete(int id) {
		pRepo.deleteById(id);
		Post post=getById(id);
		if(post==null) return true;
		return false;
	}


}
