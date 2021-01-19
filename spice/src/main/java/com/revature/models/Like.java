package com.revature.models;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Like {
	
	@Id
	@Column(name="like_id")
	@GeneratedValue
	private int likeId;
	@Column(name="post_id", nullable=false)
	private int postId;
	@Column(name="user_id", nullable=false)
	private int userId;
	
	
	public Like() {
		super();
	}

	public Like(int postId, int userId) {
		super();
		this.postId = postId;
		this.userId = userId;
	}

	public Like(int likeId, int postId, int userId) {
		super();
		this.likeId = likeId;
		this.postId = postId;
		this.userId = userId;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", postId=" + postId + ", userId=" + userId + "]";
	}
    
	
}
