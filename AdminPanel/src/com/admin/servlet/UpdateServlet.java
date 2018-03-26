package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.bean.EmpBean;
import com.admin.dao.EmpDAO;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		 int id=0;
		String sid="";
		String Uname = "";
		String email="";
		String pass="";
		String gender="";
		String dateOfBirth="";
		String mobile ="";
		String address="";
		try {
			try {
				sid=request.getParameter("id");  
		        id=Integer.parseInt(sid);  
				Uname = request.getParameter("name");
				email = request.getParameter("email");
				pass = request.getParameter("password");
				gender = request.getParameter("gender");
				dateOfBirth = request.getParameter("date");
				mobile = request.getParameter("mobile");
				address = request.getParameter("address");
			}catch(NullPointerException e) {
			e.printStackTrace();
			}
			System.out.println(pass);
			EmpBean e = new EmpBean();
			e.setId(id);
			e.setName(Uname);
			e.setPass(pass);
			e.setEmail(email);
			e.setMobile(mobile);
			e.setDOB(dateOfBirth);
			e.setGender(gender);
			e.setAddress(address);
		
			int status = EmpDAO.updateInfo(e);
			if(status>0) {
				System.out.println("Data Updated successfully");
				response.sendRedirect("ViewServlet");
			}
			else {
				pw.print("Sorry, Unable to save data");
			}
			pw.close();
	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


