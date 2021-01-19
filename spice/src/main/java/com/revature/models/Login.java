package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.revature.io.Logging;

@Entity
@Table(name="login")
public class Login {
	
	@Id
	@Column(name="user_id")
	private int user_id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Login(int user_id, String username, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		Logging.LogIt("info", "Login, "+ this.username + ", was updated");
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}


	@Override
	public String toString() {
		return "Login [user_id=" + user_id + ", username=" + username + ", password=" + password + "]";
	}

}