package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Serv")
@MultipartConfig(maxFileSize = 16177215)    
public class Serv extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		String phone=  request.getParameter("phone");
		
		InputStream inputStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			PreparedStatement ps = con.prepareStatement("insert into photo(name,photo,phone) values(?,?,?)");
			ps.setString(1, name);
			if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                ps.setBlob(2, inputStream);
            }
			ps.setString(3, phone);
			ps.executeUpdate();
			pw.println("added successfully");
			con.close();
			request.getRequestDispatcher("image.html").forward(request,response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
