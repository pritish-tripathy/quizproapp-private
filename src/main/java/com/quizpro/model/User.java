package com.quizpro.model;

public class User {
	private String userId;
	private String username;
	private String email;
	private String password;
	private String otp;
	private String city;
	
	public User() { }
	
	public User(String userId, String username, String email, String password, String otp, String city) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.otp = otp;
		this.city = city;
	}

	//dont declare getter setter, use lombok.
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
