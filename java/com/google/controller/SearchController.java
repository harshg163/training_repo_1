package com.google.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchName = request.getParameter("searchName");
		UserDao userdao = new UserDao();
		ArrayList<UserBean> users = userdao.searchData(searchName);
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("Search.jsp").forward(request, response);
	}

}
