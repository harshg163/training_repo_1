package com.google.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;


public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserBean user = new UserDao().authenticate(email, password);
		
		RequestDispatcher rd = null;
		if (user==null) {
			rd = request.getRequestDispatcher("Login.jsp");
		} else {
			rd = request.getRequestDispatcher("Home.jsp");
		}
		rd.forward(request, response);
	}

}
