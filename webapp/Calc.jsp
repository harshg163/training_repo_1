<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
</head>
<body>
	<form action="CalcServlet" method="post">
	Number 1: <input type="number" name="number_1"><br/><br/>
	Number 2: <input type="number" name="number_2"><br/><br/>
	Select Operation: <input type="radio" name="operation" value="add">+
	<input type="radio" name="operation" value="subtract">-
	<input type="radio" name="operation" value="multiply">x
	<input type="radio" name="operation" value="divide">/<br/><br/>
	<input type="submit" value="Calculate">
	</form>
</body>
</html>