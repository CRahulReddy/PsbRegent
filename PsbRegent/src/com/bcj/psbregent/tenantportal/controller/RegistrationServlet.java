package com.bcj.psbregent.tenantportal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcj.psbregent.tenantportal.model.Address;
import com.bcj.psbregent.tenantportal.model.Company;
import com.bcj.psbregent.tenantportal.model.Login;
import com.bcj.psbregent.tenantportal.model.Tenant;
import com.bcj.psbregent.tenantportal.service.RegistrationService;

/**
 * This is the RegistrationServlet where we are setting all the details entered
 * by the user in the respective entity objects and passing the object to the
 * Service layer.
 * 
 * @author Bootcamp User 021
 *
 */
public class RegistrationServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		RegistrationService registrationService = new RegistrationService();

		//Loading the data obtained from UI into the entity classes
		Address companyAddress = new Address(request.getParameter("addressLine1"), request.getParameter("addressLine2"),
				request.getParameter("city"), request.getParameter("state"), request.getParameter("zip"));

		Address tenantAddress = new Address(request.getParameter("addLine1"), request.getParameter("addLine2"),
				request.getParameter("concity"), request.getParameter("constate"), request.getParameter("conzip"));

		Company companyDetails = new Company(request.getParameter("companyName"), request.getParameter("companyEmail"),
				request.getParameter("CompanyPhone"), companyAddress);

		Tenant tenantDetails = new Tenant(request.getParameter("firstName"), request.getParameter("lastName"),
				request.getParameter("email"), request.getParameter("phone"), tenantAddress);

		Login loginDetials = new Login(request.getParameter("userId"), request.getParameter("password"));

		String coustomerId = registrationService.registerTenant(companyDetails, tenantDetails, loginDetials);

		//Generating the response in html format.
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		
		if(Integer.parseInt(coustomerId)>0){
		out.println("<h2>");
		out.print("Thanks for registration. Your registration number is : ");
		out.println(coustomerId);
		out.println("</h2>");
		out.println(
				"<a href=\"login.html\">click this link to login </a>");
		}else{
			out.print("Registration Failed");
		}
		out.println("</body>");
		out.println("</html>");

	}
}
