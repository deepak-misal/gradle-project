package com.techlabs.model;

public class LoginBean {
	private String username;
	private String password;
	
	public LoginBean(String username,String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	public LoginBean() {
		
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
