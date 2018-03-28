package com.admin.servlet;
  
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.bean.EmpBean;
import com.admin.dao.EmpDAO;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<h1  align='center'>Employee Profile</h1>");
		EmpBean e = EmpDAO.getInfoOfEmp();
		
		pw.println("<table border=2 width='50%' cellpadding='4' align='center'");
		pw.println("<tr><th>ID</th><td>"+e.getId()+"</td></tr>");
		pw.println("<tr><th>Name</th><td>"+e.getName()+"</td></tr>");
		pw.println("<tr><th>Email</th><td>"+e.getEmail()+"</td></tr>");
		pw.println("<tr><th>Password</th><td>"+e.getPass()+"</td><tr>");
		pw.println("<tr><th>Gender</th><td>"+e.getGender()+"</td></tr>");
		pw.println("<tr><th>BirthDate</th><td>"+e.getDOB()+"</td></tr>");
		pw.println("<tr><th>Contact</th><td>"+e.getMobile()+"</td></tr>");
		pw.println("<tr><th>Photo</th><td><a href='ViewImage?id="+e.getId()+"'>View Photo</td></tr>");
		pw.println("<tr><th>Address</th><td>"+e.getAddress()+"</td></tr>");
		pw.println("<tr><th>Update</th><td><a href=EditServlet?id="+e.getId()+">Update</a></td></tr>");
		pw.println("</table>");
		pw.print("<p align='center'><a href='Register.html'  style='text-align:center'>Go to Home Page</a></p>");
		pw.close();
	}
}
