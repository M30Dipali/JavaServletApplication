package com.admin.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewImage")
public class ViewImage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Connection con = null;
		try{
		    Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_panel", "root", "");
		    
		    PreparedStatement ps = con.prepareStatement("select photo from emp_profile where id=?");
		    ps.setInt(1, id);
		    ResultSet rs = ps.executeQuery();
		 
		    if(rs.next()){
		        Blob blob = rs.getBlob("photo");
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
	}

}
