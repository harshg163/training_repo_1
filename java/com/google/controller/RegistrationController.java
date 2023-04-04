package com.google.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class RegistrationController extends HttpServlet {

	@Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cPassword = request.getParameter("cPassword");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city"); 
		String hobby_1 = request.getParameter("hobby_1");
		String hobby_2 = request.getParameter("hobby_2");
		
		boolean isError = false;
		StringBuffer error = new StringBuffer("");
		String fNameCheck = "[A-Za-z]+$";
		String lNameCheck = "[A-Za-z]+$";
		String emailCheck = "[a-z0-9]+@[a-z.]+[a-z]";
		String passwordCheck = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
		if(firstName==null || firstName.trim().length()==0) {
			isError=true;
			error.append("<br> <span style='color:red;'>Please Enter FirstName</span>");
		}
		else if (firstName.matches(fNameCheck) == false) {
			isError=true;
			error.append("<br> <span style='color:red;'>Please Enter valid FirstName</span>");
		}
		if(lastName==null || lastName.trim().length()==0) {
			isError=true;
			error.append("<br> <span style='color:red;'>Please Enter FirstName</span>");
		}
		else if (lastName.matches(lNameCheck) == false) {
			isError=true;
			error.append("<br> <span style='color:red;'>Please Enter valid FirstName</span>");
		}
		
		if(email==null || email.trim().length()==0) {
			isError=true;
			error.append("<br> <span style='color:red;'>Please Enter Email</span>");
		}
		else if (email.matches(emailCheck)==false) {
			isError=true;
			error.append("<br> <span style='color:red;'>Please Enter valid Email</span>");
		}
		
		if(password==null || password.trim().length()==0) {
			isError=true;
			error.append("<br> <span style='color:red;'>Please Enter Password</span>");
		}
		else if (password.matches(passwordCheck)==false) {
			isError=true;
			error.append("<br> <span style='color:red;'>Please Enter valid Password</span>");
		}
		
		if(cPassword==null || cPassword.trim().length()==0) {
			isError=true;
			error.append("<br> <span style='color:red;'>Please confirm your password</span>");
		}
		else if (!cPassword.equals(password)) {
			isError=true;
			error.append("<br> <span style='color:red;'>Password didn't match, please try again</span>");
		}
		
		if(gender==null) {
			isError=true;
			error.append("<br><span style='color:red;'>Please select your gender</span>");
		}
		if(city==null || city.trim().length()==0) {
			isError=true;
			error.append("<br><span style='color:red;'>Please select your city</span>");
		}
		if(hobby_1==null && hobby_2==null) {
			isError=true;
			error.append("<br><span style='color:red;'>Please select your hobbies</span>");
		}
		
		RequestDispatcher rd = null;
		if (isError == true) 
		{
			request.setAttribute("error", error.toString());
			rd = request.getRequestDispatcher("Registration.jsp");
		} else 
		{

			rd = request.getRequestDispatcher("Login.jsp");
		}
			rd.forward(request, response);
	 }
}

