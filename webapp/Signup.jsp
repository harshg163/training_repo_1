<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
<style>
	.error{
		color:red;
	}
</style>
</head>
<body>
	<form action="SignupController" method="post">
	FirstName: <input type="text" name="firstName" value="${user.firstName}">
	<span class="error">${firstNameError}</span> 
	<br/><br/>
	Email: <input type="text" name="email" value="${user.email}">
	<span class="error">${emailError}</span>
	<br/><br/>
	Password: <input type="password" name="password">
	<span class="error">${passwordError}</span>
	<br/><br/>
	<input type="submit" value="Submit">
	</form>
	
</body>
</html>