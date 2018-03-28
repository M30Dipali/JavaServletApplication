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
        String name=(String)session.getAttribute("Name");  
        pw.print("<p align='center'>Hello, "+name+"</p>");  
		
        pw.print("<h1 align='center'>Employee Profile</h1>");
        String spageid=request.getParameter("page");  
        int pageid=Integer.parseInt(spageid);  
        int total=5;  
        if(pageid==1){}  
        else{  
           pageid=pageid-1;  
         pageid=pageid*total+1;  
        }  
		List<EmpBean> list= EmpDAO.getAllEmployees(pageid,total);
pw.print("<h2>Page No: "+spageid+"</h2>");
		 pw.print("<table border='1' cellpadding='4' width='100%''");  
	     pw.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Gender</th><th>BirthDate</th>");
	     pw.print("<th>Contact</th><th>Photo</th><th>Address</th><th>Delete</th></tr>");
	     for(EmpBean e:list) {  
	        pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPass()+"</td>");
	        pw.print("<td>"+e.getGender()+"</td><td>"+e.getDOB()+"</td><td>"+e.getMobile()+"</td><td><a href='ViewImage?id="+e.getId()+"'>View Photo</td><td>"+e.getAddress()+"</td>");
	        pw.print("<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
	        
	     }  
	     pw.print("</table>"); 
	     pw.print("<a href='ViewEmpServlet?page=1'>1</a> ");  
	        pw.print("<a href='ViewEmpServlet?page=2'>2</a> ");  
	        pw.print("<a href='ViewEmpServlet?page=3'>3</a> ");  
	        pw.print("<a href='ViewEmpServlet?page=4'>4</a> ");  
	        pw.print("<a href='ViewEmpServlet?page=5'>5</a> "); 
	     pw.println("<p align='center'><a href='LogoutServlet'>Logout</a></p>");
        }
		pw.close();
	}

	
}
