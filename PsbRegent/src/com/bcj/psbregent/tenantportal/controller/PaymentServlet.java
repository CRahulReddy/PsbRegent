package com.bcj.psbregent.tenantportal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcj.psbregent.tenantportal.model.CreditCard;
import com.bcj.psbregent.tenantportal.service.PaymentService;

/**This is the payment servlet which is used to to forward the credit card detials entered by the user to the service layer and prints 
 * whether the payment is successfull or not based on the reponse from the service layer
 * 
 * @author Bootcamp User 021
 *
 */
public class PaymentServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Loading the data obtained from UI into the entity classes
		CreditCard creditCardDetails = new CreditCard(request.getParameter("nameOnCard"),
				request.getParameter("cardNumber"), request.getParameter("cvv"), request.getParameter("expirationDate"),
				request.getParameter("rentAmount"));

		int status = PaymentService.processPayment(creditCardDetails);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		//Generating the response in html format.
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");
		
		if (status > 0) {
			
			out.println("<h2 align=\"right\"><a  href=\"login.html\">Logout</a></h2>");
			out.println("<h2 align=\"center\"> Payment Successfull!!</h2>");
			
			
		} else {
			
			out.println("<h2 align=\"right\"><a  href=\"login.html\">Logout</a></h2>");
			out.print("<h2 align=\"center\"> Payment failed.</h2><br>");
			out.println("<h3 align=\"center\"><a href=\"payment.html\">Click this link to enter valid payment detials.</a></h3>");
		
		}

		out.println("</body></html>");
		

	}

}
