<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<% String error = (String)request.getAttribute("error"); %>
	<h1>Registration Page</h1>
	<form action="Registration" method="post">
	FirstName* : <input type="text" name="firstName"><br/><br/>
	LastName* : <input type="text" name="lastName"><br/><br/>
	Gender* : <input type="radio" name="gender" value="Male">Male
			<input type="radio" name="gender" value="Female">Female<br/><br/>
	Email* : <input type="email" name="email"><br/><br/>
	Password* : <input type="password" name="password"><br/><br/>
	Confirm Password* : <input type="password" name="cPassword"><br/><br/>
	City* : <select name="city">
			<option value="">Select Your City</option>
			<option value="Jaipur">Jaipur</option>
			<option value="Ahmedabad">Ahmedabad</option>
			<option value="Mumbai">Mumbai</option>
		</select>
		<br/><br/>
	Hobbies* : <input type="checkbox" name="hobby_1" value="travelling">Travelling
			 <input type="checkbox" name="hobby_2" value="Watching Matches">Watching Movies<br/><br/>	
	<input type="submit" value="Register">
	</form>
	<br/><br/>
	<%=error!=null?error:"" %>
</body>
</html>