<%@page import="java.util.ArrayList"%>
<%@page import="com.google.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Users</title>
</head>
<body>
	<% ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users"); 
	%>
	<table border="1">
	<tr>
	<th>UserId</th>
	<th>Name</th>
	<th>Email</th>
	<th>Password</th>
	<th>Delete</th>
	<th>Edit</th>
	</tr>
	<% for(UserBean user: users) {%>
	<tr>
	<td><%=user.getUserId() %></td>
	<td><%=user.getFirstName() %></td>
	<td><%=user.getEmail() %></td>
	<td><%=user.getPassword() %></td>
	<td><a href="DeleteController?userId=<%=user.getUserId() %>">Delete</a></td>
	<td><a href="EditUsersController?userId=<%=user.getUserId() %>">Edit</a></td>
	</tr>
	<% }%>
	</table>
	
	<a href="SearchController">Search</a>
</body>
</html>