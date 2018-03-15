package servletDemo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import EmpData.EmpBean;
import EmpData.EmpDAO;

@WebServlet("/ViewEmpServlet")
public class ViewEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<a href='register.html'>Add New Employee</a>");
		pw.print("<h1>Employee List</h1>");
		
		List<EmpBean> list =EmpDAO.getAllEmpInfo();
		pw.println("<table border=2 width='100%'");
		pw.println("<tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Contact</th><th>BirthDate</th><th>City</th><th>Country</th><th>Edit</th><th>Delete</th><tr>");
		for(EmpBean e : list) {
			pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPass()+"</td><td>"+e.getEmail()+"</td><td>"+e.getMobile()+"</td><td>"+e.getDOB()+"</td><td>"+e.getCity()+"</td><td>"+e.getCountry()+"</td><td><a href='EditEmpServlet?id="+e.getId()+"'>Edit</a></td><td><a href='DeleteEmpServlet?id="+e.getId()+"'>Delete</a></td></tr>");
		}
		pw.println("</table>");
		pw.close();
	}

}
