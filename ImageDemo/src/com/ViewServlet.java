package com;

import java.io.IOException;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		 
		String connectionURL = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pass = "";
		 
		Connection con = null;
		 
		try{
		    Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection(connectionURL, user, pass);
		    
		    PreparedStatement ps = con.prepareStatement("select * from data where id=?");
		    ps.setInt(1, id);
		    ResultSet rs = ps.executeQuery();
		 
		    if(rs.next()){
		        Blob blob = rs.getBlob("image");
		        byte byteArray[] = blob.getBytes(1, (int)blob.length());
		 
		        response.setContentType("image/gif");
		        OutputStream os = response.getOutputStream();
		        os.write(byteArray);
		        os.flush();
		        os.close();
		    }
		}
		catch(Exception e){
		    e.printStackTrace();
		}   
		finally{
		    if(con != null){
		        try{
		            con.close();
		        }
		        catch(Exception e){
		            e.printStackTrace();
		        }
		 }
		}
	}}
