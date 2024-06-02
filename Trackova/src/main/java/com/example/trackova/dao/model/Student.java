package com.example.trackova.dao.model;

public class Student {
	String username;
	String name;
	String emailId;
	String state;
	String  district;
	long phoneno;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public Student(String username, String name, String emailId, String state, String district, long phoneno) {
		super();
		this.username = username;
		this.name = name;
		this.emailId = emailId;
		this.state = state;
		this.district = district;
		this.phoneno = phoneno;
	}
	
}
