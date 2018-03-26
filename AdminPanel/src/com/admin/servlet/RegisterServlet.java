package com.admin.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.admin.bean.EmpBean;
import com.admin.dao.EmpDAO;
import javax.servlet.http.HttpSession;
@WebServlet("/RegisterServlet")
@MultipartConfig(maxFileSize = 16177215) 
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String Uname = "";
		String email="";
		String pass="";
		String gender="";
		String dateOfBirth="";
		String mobile ="";
		String address="";
		try {
		Uname = request.getParameter("ename");
		email = request.getParameter("email");
		pass = request.getParameter("pass");
		gender = request.getParameter("gender");
		dateOfBirth = request.getParameter("date");
		mobile = request.getParameter("mobile");
		address = request.getParameter("address");
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		 InputStream inputStream =null; 
		Part filePart = request.getPart("photo");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        
		EmpBean e = new EmpBean();
		e.setName(Uname);
		e.setEmail(email);
		e.setPass(pass);
		e.setGender(gender);
		e.setDOB(dateOfBirth);
		e.setMobile(mobile);
		e.setAddress(address);
		int status = EmpDAO.saveInfo(e, inputStream);
		
		if(status>0) {
			pw.print("<p align='center'>Data inserted successfully</p>");
			request.getRequestDispatcher("Welcome.html").include(request, response);
		}
		else {
			pw.print("Sorry, Unable to save data");
		}
		pw.close();
	}

}
