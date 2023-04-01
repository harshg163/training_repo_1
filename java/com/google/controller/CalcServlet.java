package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int number_1 = Integer.parseInt(request.getParameter("number_1"));
		int number_2 = Integer.parseInt(request.getParameter("number_2"));
		String operation = request.getParameter("operation");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(operation.equals("add")) {
			out.println(number_1+" + " +number_2 +" = "+ (number_1+number_2)+"<br/>");
		}
		else if (operation.equals("subtract")) {
			out.println(number_1+" - "+number_2+" = "+(number_1-number_2)+"<br/>");
		}
		else if (operation.equals("multiply")) {
			out.println(number_1+" x "+number_2+" = "+(number_1*number_2)+"<br/>");
		}
		else if(operation.equals("divide")){
			out.println(number_1+" / "+number_2+" = "+(number_1/number_2)+"<br/>");
		}
	}
}
