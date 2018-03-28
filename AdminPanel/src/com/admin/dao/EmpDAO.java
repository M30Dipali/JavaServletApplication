package com.admin.dao;

import java.util.List;

import java.util.ArrayList;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.admin.bean.EmpBean;
import com.admin.dao.EmpDAO;


public class EmpDAO {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_panel","root","");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static int saveInfo(EmpBean e,  InputStream inputStream) {
		int status = 0;
		try {
			Connection con = EmpDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into emp_profile(name,email,password,gender,birthdate,contact,photo,address) values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1, e.getName());
			ps.setString(2,e.getEmail());
			ps.setString(3, e.getPass());
			ps.setString(4,e.getGender());
			ps.setString(5, e.getDOB());
			ps.setString(6, e.getMobile());
			if (inputStream != null) {
	           
	            ps.setBlob(7, inputStream);
	        }
			ps.setString(8, e.getAddress());
			
			status = ps.executeUpdate();
			System.out.println("Inserted successfully");
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static EmpBean getInfoOfEmp() {
		EmpBean e = new EmpBean();
		try {
			Connection con = EmpDAO.getConnection();
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from emp_profile where id=(select max(id) from emp_profile)");  
			
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPass(rs.getString(4));
				e.setGender(rs.getString(5));
				e.setDOB(rs.getString(6));
				e.setMobile(rs.getString(7));
				e.setAddress(rs.getString(9));
			}
			con.close();
		}catch(Exception ex2) {
			ex2.printStackTrace();
		}
		return e;
	}
	public static EmpBean getElementById(int id) {
		EmpBean e = new EmpBean();
		try {
			Connection con = EmpDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from emp_profile where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPass(rs.getString(4));
				e.setGender(rs.getString(5));
				e.setDOB(rs.getString(6));
				e.setMobile(rs.getString(7));
				e.setAddress(rs.getString(9));
			}
			con.close();
		}catch(Exception ex2) {
			ex2.printStackTrace();
		}
		return e;
	}
	public static int updateInfo(EmpBean e) {
		int status=0;
		try {
			Connection con = EmpDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("update emp_profile set name=?, email=?, password=?, gender=?, birthdate=?, contact=?, address=? where id=?");
			
			ps.setString(1, e.getName());
			ps.setString(2,e.getEmail());
			ps.setString(3, e.getPass());
			ps.setString(4, e.getGender());
			ps.setString(5, e.getDOB());
			ps.setString(6, e.getMobile());
			
			ps.setString(7, e.getAddress());
			ps.setInt(8, e.getId());
			
			status = ps.executeUpdate();
			System.out.println("Inserted successfully");
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static List<EmpBean> getAllEmployees(int start,int total){  
        List<EmpBean> list=new ArrayList<EmpBean>();  
          
        try{  
            Connection con=EmpDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emp_profile  limit "+(start-1)+","+total);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	EmpBean e = new EmpBean();
    				e.setId(rs.getInt(1));
    				e.setName(rs.getString(2));
    				e.setEmail(rs.getString(3));
    				e.setPass(rs.getString(4));
    				e.setGender(rs.getString(5));
    				e.setDOB(rs.getString(6));
    				e.setMobile(rs.getString(7));
    				e.setAddress(rs.getString(9));
    			
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
 public static int deleteInfo(int id) {
		int status =0;
		try {
			Connection con = EmpDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from emp_profile where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		}catch(Exception ex3) {
			ex3.printStackTrace();
		}
		return status;
	}
 
}
