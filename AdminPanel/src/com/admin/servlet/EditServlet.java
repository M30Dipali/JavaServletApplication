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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		EmpBean e = EmpDAO.getElementById(id);
		
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='ISO-8859-1'>");
		 out.print("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		 out.print("<script type='text/javascript' src='js/jquery-1.7.1.min.js'></script>");  
		out.print("<script src='js/jquery.validate.js'></script>");  
		out.print("<link rel='stylesheet' href='//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css'>");
		out.print("<script src='https://code.jquery.com/ui/1.12.1/jquery-ui.js'></script>");
		out.print("<script>");
		  out.print("$( function() {");
		    out.print("$( '#datepicker').datepicker({");
		      out.print("changeMonth: true,");
		     out.print("changeYear:true,");
		      out.print("yearRange: '1970:2000',");
		    	  out.print("dateFormat: 'dd/mm/yy'");
		    out.print("});");
		 out.print(" } );");
		 out.print(" </script>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<div align='center'");
		out.print("<h2><b>Update Employee Infomation</b></h2><br><br>");
		out.print("<form action='UpdateServlet' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+id+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPass()+"'></td></tr>");
        out.print("<tr><td>Gender :</td></tr>");
		out.print("<tr><td><input type='radio' name='gender'  value='Male' checked>Male");
		out.print("<input type='radio' name='gender' value='Female'>Female</td></tr>");
		out.print("<tr><td>DateOfBirth:</td><td><input type='text' id='datepicker' name='date' value='"+e.getDOB()+"'/></td></tr>");
        out.print("<tr><td>Contact No.:</td><td><input type='number' name='mobile' value='"+e.getMobile()+"'/></td></tr>");
        out.print("<tr><td>Address :</td></tr>");
		out.print("<tr><td><textarea name='address' value='"+e.getAddress()+"'></textarea></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
        out.print("</div>");
        out.print("</body>");
        out.print("</html>");
		out.close();
	}

}
