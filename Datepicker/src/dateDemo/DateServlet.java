package dateDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DateServlet")
public class DateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String dt = request.getParameter("date");

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datepicker", "root", "");
            PreparedStatement ps = con.prepareStatement("insert into datedemo(Birthdate) values(?)");
           // java.util.Date date = new SimpleDateFormat("dd-mm-yy").parse(dt);
            //java.sql.Date d = new java.sql.Date(date.getTime());
            ps.setString(1, dt);//date format of sql database is 'yy-mm-dd' while inserting it take default month thats why inserting in string format
            ps.executeUpdate();
            out.println("date added");
		} catch (Exception e) {
            System.out.println(e);
        }
	}

}
