package servletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EmpData.EmpDAO;

@WebServlet("/DeleteEmpServlet")
public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/type");
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		int status= EmpDAO.deleteInfo(id);
		if(status>0) {
			response.sendRedirect("ViewEmpServlet");
		}
		else {
			pw.print("Unable to delete records");
		}
	}

}
