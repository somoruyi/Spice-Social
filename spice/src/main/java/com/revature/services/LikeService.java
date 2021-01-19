package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Like;
import com.revature.repository.LikeRepository;



@Service
public class LikeService {
	
	private LikeRepository likeRepo;

	@Autowired
	public LikeService(LikeRepository likeRepo) {
		this.likeRepo = likeRepo;
	}
	
	@Transactional
	(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public List<Like> getAllLikes(){
		return (List<Like>) likeRepo.findAll();
	}
}
	