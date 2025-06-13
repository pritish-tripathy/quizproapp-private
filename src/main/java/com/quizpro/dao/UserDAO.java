package com.quizpro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	private String jdbcUrl = "jdbc:mysql://localhost:6990/quizprodb";
	private String dbUser = "root";
	private String dbPassword = "password";
	
	public boolean verifyUser(String userId, String password) {
		try(
				Connection con = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
				) {
			String sqlQuery = "SELECT * FROM myusers WHERE userId=? AND password=?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public void updateOTP(String userId, String otp) {
		try(
				Connection con = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)
				) {
			String sqlQuery = "UPDATE myusers SET otp=? WHERE userId=?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, otp);
			ps.setString(2, userId);
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean verifyOTP(String userId, String otp) {
		try (
				Connection con = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
				){
			String sqlQuery = "SELECT * FROM myusers WHERE userId=? AND otp=?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userId);
			ps.setString(2, otp);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	} 
}
