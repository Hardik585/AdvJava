package com.hardik;

public class User {

	private String name;
	private String course;
	private String address;
	private Long number;
	private String gmail;
	private String pass;
	
	public User(String name, String course, String address, Long number, String gmail, String pass) {
		super();
		this.name = name;
		this.course = course;
		this.address = address;
		this.number = number;
		this.gmail = gmail;
		this.pass = pass;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
