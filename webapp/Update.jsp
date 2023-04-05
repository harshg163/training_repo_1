<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update data</title>
<style>
	.error{
		color:red;
	}
</style>
</head>
<body>
	<form action="EditUsersController" method="post">
	<input type="hidden" name="userId" value="${param.userId}">
	FirstName: <input type="text" name="firstName" value="${user.firstName}">
	<span class="error">${firstNameError}</span> 
	<br/><br/>
	Email: <input type="text" name="email" value="${user.email}">
	<span class="error">${emailError}</span>
	<br/><br/>
	Password: <input type="password" name="password" value="${user.password}">
	<span class="error">${passwordError}</span>
	<br/><br/>
	<input type="submit" value="Submit">
	</form>
</body>
</html>