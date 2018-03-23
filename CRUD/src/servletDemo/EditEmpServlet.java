package servletDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EmpData.EmpBean;
import EmpData.EmpDAO;

@WebServlet("/EditEmpServlet")
public class EditEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>Update Employee Info</h1>");
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		EmpBean e = EmpDAO.getElementById(id);
		out.print("<form action='UpdateEmpServlet' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+id+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPass()+"'></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
        out.print("<tr><td>Contact No.:</td><td><input type='number' name='mobile' value='"+e.getMobile()+"'/></td></tr>");
        out.print("<tr><td>DateOfBirth:</td><td><input type='text' name='dob' value='"+e.getDOB()+"'/></td></tr>");
        out.print("<tr><td>City:</td><td>");  
        out.print("<select name='city' style='width:150px'>");  
        out.print("<option>Mumbai</option>");  
        out.print("<option>Pune</option>");  
        out.print("<option>Hydrabad</option>");  
        out.print("<option>Kerala</option>");  
        out.print("<option>Other</option>");  
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td>Country:</td><td>");  
        out.print("<select name='country' style='width:150px'>");  
        out.print("<option>India</option>");  
        out.print("<option>USA</option>");  
        out.print("<option>UK</option>");  
        out.print("<option>Other</option>");  
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
		out.close();
	}

}
