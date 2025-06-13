<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verify OTP</title>
</head>
<body style="margin: 0; padding: 0;">
	<div style="background-color: black;">
		<h1
			style="text-align: center; color: white; margin: 0; padding: 10px 0;">
			QuizPro<sup>TM</sup> Application
		</h1>
	</div>
	<div
		style="display: flex; justify-content: center; align-items: center; flex-direction: column; margin-top: 40px;">
		<form method="post" action="verifyOTP">
			<table>
				<tr>
					<td>Enter OTP:</td>
					<td><input type="text" name="otp" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><p style="color: red">${error}</p></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>