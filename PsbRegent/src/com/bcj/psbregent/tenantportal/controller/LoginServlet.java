package com.bcj.psbregent.tenantportal.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcj.psbregent.tenantportal.model.Login;
import com.bcj.psbregent.tenantportal.service.LoginService;



/**
 * This is the login servlet which passes the user login details to the service layer for authentication purpose.
 * 
 * @author Bootcamp User 021
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//Loading the data obtained from UI into the entity classes
		Login loginDetails = new Login(request.getParameter("userid"), request.getParameter("password"));

		//Generating the response in html format.
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");

		if (LoginService.authenticateUser(loginDetails)) {

			out.println("<h2 align=\"right\"><a  href=\"login.html\">Logout</a></h2>");
			out.println("<h2 align=\"center\">You have Logged in Successfully.</h2></br></br>");
			out.println("<h2 align=\"center\"><a href=\"payment.html\">Click this link to pay the rent</a></h2>");
			
		} else {
			
			out.println("<h2 align=\"right\"><a  href=\"login.html\">Logout</a></h2>");
			out.println("<h2 align=\"center\">Login failed.Please enter valid details</h2>");
			out.println("<h2 align=\"center\"><a href=\"login.html\">Click this link to enter correct login credentials.</a></h2>");
		
		}

		out.println("</body></html>");
	}

}
