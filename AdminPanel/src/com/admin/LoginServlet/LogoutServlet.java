package com.admin.LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
                  
        HttpSession session=request.getSession();  
        session.invalidate();  
          
        out.print("<p align='center'>You are successfully logged out!</p>");  
        out.print("<p align='center'><a href='Register.html'  style='text-align:center'>Go to Home Page</a></p>");
        out.close();  
	}


}
