package EmpData;

import java.sql.*;
import java.util.*;

public class EmpDAO {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empinfo","root","");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public static int saveInfo(EmpBean e) {
		int status = 0;
		try {
			Connection con = EmpDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into emp_details(ID,Name, Password, Email, Contact, BirthDate, City, Country) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getPass());
			ps.setString(4,e.getEmail());
			ps.setString(5, e.getMobile());
			ps.setString(6, e.getDOB());
			ps.setString(7, e.getCity());
			ps.setString(8, e.getCountry());
			
			status = ps.executeUpdate();
			System.out.println("Inserted successfully");
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static int updateInfo(EmpBean e) {
		int status=0;
		try {
			Connection con = EmpDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("update emp_details set Name=?,Password=?,Email=?,Contact=?,BirthDate=?,City=?,Country=? where Id=?");
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getPass());
			ps.setString(3,e.getEmail());
			ps.setString(4, e.getMobile());
			ps.setString(5, e.getDOB());
			ps.setString(6, e.getCity());
			ps.setString(7, e.getCountry());
			ps.setInt(8, e.getId());
			
			status = ps.executeUpdate();
			System.out.println("Inserted successfully");
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static int deleteInfo(int id) {
		int status =0;
		try {
			Connection con = EmpDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from emp_details where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		}catch(Exception ex3) {
			ex3.printStackTrace();
		}
		return status;
	}
	public static EmpBean getElementById(int id) {
		EmpBean e = new EmpBean();
		try {
			Connection con = EmpDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from emp_details where Id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPass(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setMobile(rs.getString(5));
				e.setDOB(rs.getString(6));
				e.setCity(rs.getString(7));
				e.setCountry(rs.getString(8));
			}
			con.close();
		}catch(Exception ex2) {
			ex2.printStackTrace();
		}
		return e;
	}
	public static List<EmpBean> getAllEmpInfo() {
		List<EmpBean> list = new ArrayList<EmpBean>();
		try {
			Connection con = EmpDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from emp_details");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EmpBean e = new EmpBean();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPass(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setMobile(rs.getString(5));
				e.setDOB(rs.getString(6));
				e.setCity(rs.getString(7));
				e.setCountry(rs.getString(8));
				
				list.add(e);
			}
			con.close();
		}catch(Exception ex1) {
			ex1.printStackTrace();
		}
		return list;
	}
}
