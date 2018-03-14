package servletDemo;
import EmpData.EmpBean;
import EmpData.EmpDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveEmpServlet")
public class SaveEmpServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try {
		String id = request.getParameter("id");
		String Uname = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String dateOfBirth = request.getParameter("dob");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		EmpBean e = new EmpBean();
		e.setId(id);
		e.setName(Uname);
		e.setPass(pass);
		e.setEmail(email);
		e.setMobile(mobile);
		e.setDOB(dateOfBirth);
		e.setCity(city);
		e.setCountry(country);
		
		int status = EmpDAO.saveInfo(e);
		if(status>0) {
			pw.print("<p>Data inserted successfully</p>");
			request.getRequestDispatcher("register.html").include(request, response);
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
