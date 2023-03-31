package com.google.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		int number_1 = Integer.parseInt(request.getParameter("number_1"));
		int number_2 = Integer.parseInt(request.getParameter("number_2"));
		String operation = request.getParameter("operation");
		if(operation.equals("add")) {
			System.out.println("Addition: "+(number_1+number_2));
		}
		else if (operation.equals("subtract")) {
			System.out.println("Subtraction: "+(number_1-number_2));
		}
		else if (operation.equals("multiply")) {
			System.out.println("Multiplication: "+(number_1*number_2));
		}
		else if(operation.equals("divide")){
			System.out.println("Division: "+(number_1/number_2));
		}
	}
}
