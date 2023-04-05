<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>LOGIN PAGE</h1>
<form action="AuthenticationController" method="post">
	<input type="text" name="email" /><br/><br/>
	<input type="text" name="password" /><br/><br/>
	<input type="submit" value="login"/>
</form>
</body>
</html>