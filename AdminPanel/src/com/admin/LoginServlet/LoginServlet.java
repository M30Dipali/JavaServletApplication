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
		
		String name=request.getParameter("name"); 
		
        HttpSession session=request.getSession();  
        session.setAttribute("Name",name);  
		
        pw.println("<h3 align='center'>Welcome "+name+" You are successfully Login</h3>");
		pw.print("<p align='center'><a href='ViewEmpServlet?page=1'>View Employee Records</a></p>");
	}

}
