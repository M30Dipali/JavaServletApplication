package EmpData;

import java.sql.Date;

public class EmpBean {
	private String id;
	private String name, pass, email,city, country,mobile,dob;
	
	
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	public String getMobile(){
		return mobile;
	}
	public void setDOB(String dob){
		this.dob=dob;
	}
	public String getDOB(){
		return dob;
	}
	public void setCity(String city){
		this.city=city;
	}
	public String getCity(){
		return city;
	}
	public void setCountry(String country){
		this.country=country;
	}
	public String getCountry(){
		return country;
	}
	public void setPass(String pass){
		this.pass=pass;
	}
	public String getPass(){
		return pass;
	}
}
