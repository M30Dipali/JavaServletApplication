package image;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/ImageDemo")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*5)
public class ImageDemo extends HttpServlet {
	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
	//private static final String SAVE_DIR="ImageDemoFolder";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out1 = response.getWriter()) {
	            HttpSession session=request.getSession();
	            Part filePart = request.getPart("photo");
	            String photo="";
	           //String path="ImageDemoFolder";
	            //File file=new File(path);
	            //file.mkdir();
	           String fileName = getFileName(filePart);
	          OutputStream out = null;
	          InputStream filecontent = null;
	          PrintWriter writer = response.getWriter();
	          try {
	        	  out = new FileOutputStream(new File(fileName));
	        	   filecontent = filePart.getInputStream();
	        	   int read = 0;
	        	   final byte[] bytes = new byte[1024];
	        	   while ((read = filecontent.read(bytes)) != -1) {
	        		   out.write(bytes, 0, read);
	        		   photo=fileName;
	        	   }
	              Connection con=null;
	              Class.forName("com.mysql.jdbc.Driver");
	              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imagedemo","root","");
	              PreparedStatement ps = con.prepareStatement("insert into upload(photopath) values(?)");
	              ps.setString(1,photo);
	              ps.executeUpdate();
	              out1.print("successfully inserted");
	              con.close();
	           }catch(Exception ex) {
	        	   	ex.printStackTrace();
	           }
	           
	       }
		}
	}
	 