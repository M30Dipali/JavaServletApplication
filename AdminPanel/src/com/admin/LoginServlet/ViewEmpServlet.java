package com.admin.LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.bean.EmpBean;
import com.admin.dao.EmpDAO;

@WebServlet("/ViewEmpServlet")
public class ViewEmpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        String email=(String)session.getAttribute("Email");  
        pw.print("<p align='center'>Hello, "+email+"</p>");  
		
        pw.print("<h1 align='center'>Employee Profile</h1>");
		List<EmpBean> list= EmpDAO.getAllEmployees();
		
		 pw.print("<table border='1' width='100%'");  
	     pw.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Gender</th><th>BirthDate</th>");
	     pw.print("<th>Contact</th><th>Address</th><th>Delete</th></tr>");
	     for(EmpBean e:list) {  
	        pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPass()+"</td>");
	        pw.print("<td>"+e.getGender()+"</td><td>"+e.getDOB()+"</td><td>"+e.getMobile()+"</td><td>"+e.getAddress()+"</td>");
	        pw.print("<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
	        
	     }  
	     pw.print("</table>"); 
	     pw.println("<p align='center'><a href='LogoutServlet'>Logout</a></p>");
        }
		pw.close();
	}

	
}
