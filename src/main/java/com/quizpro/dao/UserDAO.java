package com.quizpro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	// use hibernate here. move these to app.pro
	private String jdbcUrl = "jdbc:mysql://localhost:6990/quizprodb?useSSL=false";
	private String dbUser = "root";
	private String dbPassword = "password";
	
	public boolean verifyUser(String userIdOrUsername, String password) {
		try(
				Connection con = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
				) {
			String sqlQuery = "SELECT * FROM myusers WHERE (userId=? OR username=?) AND password=?";
	        PreparedStatement ps = con.prepareStatement(sqlQuery);
	        ps.setString(1, userIdOrUsername);
	        ps.setString(2, userIdOrUsername);
	        ps.setString(3, password);
	        ResultSet rs = ps.executeQuery();
	        return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public void updateOTP(String userIdOrUsername, String otp) {
		try(
				Connection con = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)
				) {
			String sqlQuery = "UPDATE myusers SET otp=? WHERE userId=? OR username=?";
	        PreparedStatement ps = con.prepareStatement(sqlQuery);
	        ps.setString(1, otp);
	        ps.setString(2, userIdOrUsername);
	        ps.setString(3, userIdOrUsername);
	        ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean verifyOTP(String userIdOrUsername, String otp) {
		try (
				Connection con = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
				){
			String sqlQuery = "SELECT * FROM myusers WHERE (userId=? OR username=?) AND otp=?";
	        PreparedStatement ps = con.prepareStatement(sqlQuery);
	        ps.setString(1, userIdOrUsername);
	        ps.setString(2, userIdOrUsername);
	        ps.setString(3, otp);
	        ResultSet rs = ps.executeQuery();
	        return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	} 
}
