package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupController extends HttpServlet  {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("Signup");
		
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		boolean isError = false;
		StringBuffer error = new StringBuffer("");
		String fNameCheck = "[A-Za-z]+$";
		String emailCheck = "[a-z0-9]+@[a-z.]+[a-z]";
		String passwordCheck = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
		if(firstName==null || firstName.trim().length()==0) {
			isError=true;
			error.append("<br> Please Enter FirstName");
		}
		else if (firstName.matches(fNameCheck) == false) {
			isError=true;
			error.append("<br> Please Enter valid FirstName");
		}
		
		if(email==null || email.trim().length()==0) {
			isError=true;
			error.append("<br> Please Enter Email");
		}
		else if (email.matches(emailCheck)==false) {
			isError=true;
			error.append("<br> Please Enter valid Email");
		}
		
		if(password==null || password.trim().length()==0) {
			isError=true;
			error.append("<br> Please Enter Password");
		}
		else if (password.matches(passwordCheck)==false) {
			isError=true;
			error.append("<br> Please Enter valid Password");
		}
		if (isError == true) {
			out.print("<p style='color:red;'>"+error+"</p>");
		}
		else {
		out.println("First Name: "+firstName+"<br>");
		out.println("Email: "+email+"<br>");
		out.println("Password: "+password+"<br>");
		}
	}
}
