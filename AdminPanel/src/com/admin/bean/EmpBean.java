package com.admin.bean;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.Part;

public class EmpBean {
	private int id;
	private String name, pass, email, gender, address, mobile, dob;
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
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
	public void setGender(String gender){
		this.gender=gender;
	}
	public String getGender(){
		return gender;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setPass(String pass){
		this.pass=pass;
	}
	public String getPass(){
		return pass;
	}
}


