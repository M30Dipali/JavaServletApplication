package EmpData;

import java.sql.*;

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
			ps.setString(1, e.getId());
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
}
