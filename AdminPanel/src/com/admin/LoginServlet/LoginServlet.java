package com.admin.LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String email=request.getParameter("email"); 
		
        HttpSession session=request.getSession();  
        session.setAttribute("Email",email);  
		
        pw.println("<h3 align='center'>Welcome "+email+" You are successfully Login</h3>");
		pw.print("<p align='center'><a href='ViewEmpServlet'>View Employee Records</a></p>");
	}

}
