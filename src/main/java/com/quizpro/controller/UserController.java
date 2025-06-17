package com.quizpro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.quizpro.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getLoginPage() {
		return "LoginPage";
	}

	@PostMapping("/verifyUser")
	public String verifyUser(HttpServletRequest request, HttpSession session) {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		if (userService.verifyUser(userId, password)) {
			String otp = userService.generateOTP();
			userService.updateOTP(userId, otp);
			String email = userService.getEmailByUserIdOrUsername(userId);
			userService.sendEmail(email, otp);
			session.setAttribute("userId", userId);
			return "SubmitOTP";
		} else {
			request.setAttribute("errorMsg", "Invalid userId or Password");
			return "LoginPage";
		}
	}

	@PostMapping("/verifyOTP")
	public String verifyOTP(HttpServletRequest request, HttpSession session) {
		String otp = request.getParameter("otp");
		String userId = (String) session.getAttribute("userId");
		if (userService.verifyOTP(userId, otp)) {
			return "HomePage";
		} else {
			request.setAttribute("error", "Invalid OTP");
			return "SubmitOTP";
		}
	}
}
