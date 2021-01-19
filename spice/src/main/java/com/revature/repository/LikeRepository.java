package com.revature.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Like;

public interface LikeRepository extends JpaRepository<Like, Integer>{

	public List<Like> findAll();
	//public List<Like> findById(int likeId);

}
