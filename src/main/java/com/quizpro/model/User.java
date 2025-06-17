package com.quizpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String userId;
	private String username;
	private String email;
	private String password;
	private String otp;
	private String city;
}
