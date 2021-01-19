package com.revature.repository;



import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.revature.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
	@Query(value = "SELECT * FROM posts WHERE user_id=:user_id", nativeQuery = true)
	public List<Post> findByUserId(@Param("user_id") int user_id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE posts SET like_count=like_count+1 WHERE post_id=:post_id", nativeQuery = true)
	public void getLikes(@Param("post_id") int post_id);
}
