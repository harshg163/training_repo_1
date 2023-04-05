<%@page import="java.util.ArrayList"%>
<%@page import="com.google.bean.UserBean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<form action="SearchController" method="post">
Name: <input type="text" name="searchName" />
	  <input type="submit" value="search" />
	</form>
	
	<table border="1" cellspacing="0">
	<tr>
	<th>UserId</th>
	<th>Name</th>
	<th>Email</th>
	<th>Password</th>
	</tr>
	<c:forEach items="${users}" var="user">
	<tr>
	<td>${user.userId}</td>
	<td>${user.firstName}</td>
	<td>${user.email}</td>
	<td>${user.password}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>