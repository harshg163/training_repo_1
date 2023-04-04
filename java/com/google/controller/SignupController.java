package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.util.DbConnection;

public class SignupController extends HttpServlet  {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		System.out.println("Signup");
		
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		boolean isError = false;
//		StringBuffer error = new StringBuffer("");
		String fNameCheck = "[A-Za-z]+$";
		String emailCheck = "[a-z0-9]+@[a-z.]+[a-z]";
		String passwordCheck = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
		if(firstName==null || firstName.trim().length()==0) {
			isError=true;
			request.setAttribute("firstNameError", "Please Enter FirstName");
		}
		else if (firstName.matches(fNameCheck) == false) {
			isError=true;
			request.setAttribute("firstNameError", "Please Enter valid FirstName");
		}
		else {
			request.setAttribute("firstName", firstName);
		}
		if(email==null || email.trim().length()==0) {
			isError=true;
			request.setAttribute("emailError", "Please Enter Email");
		}
		else if (email.matches(emailCheck)==false) {
			isError=true;
			request.setAttribute("emailError", "Please Enter valid Email");
		}
		else {
			request.setAttribute("email", email);
		}
		
		if(password==null || password.trim().length()==0) {
			isError=true;
			request.setAttribute("passwordError", "Please enter Password");
		}
		else if (password.matches(passwordCheck)==false) {
			isError=true;
			request.setAttribute("passwordError", "Please Enter valid Password");
		}
		
		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("Signup.jsp");
		}
		else {
			Connection cn = DbConnection.appConnection();
			try {
				PreparedStatement pst = cn.prepareStatement("insert into users(firstName, email, password) values(?, ?, ?)");
				pst.setString(1, firstName);
				pst.setString(2, email);
				pst.setString(3, password);
				int inserted = pst.executeUpdate();
				if (inserted>0) {
					System.out.println("Data inserted successfully");
				} else {
					System.out.println("data not inserted");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rd = request.getRequestDispatcher("Login.jsp");
		}
		rd.forward(request, response);
	}
}
