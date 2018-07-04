package com.jarrm5.model;

import javax.persistence.*;

public class AppUser {
	
	int userId;
	String username;
	String password;
	
	public AppUser() {}
	
	public AppUser(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

}
