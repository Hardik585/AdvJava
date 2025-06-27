package com.hardik;

public class Employ {

	private int emp_id;
	private String name;
	private String work_location;
	private String dept;
	private String gender;

	public Employ(int emp_id, String name, String work_location, String dept, String gender) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.work_location = work_location;
		this.dept = dept;
		this.gender = gender;
	}

	public Employ(String name, String work_location, String dept, String gender) {
		super();
		this.name = name;
		this.work_location = work_location;
		this.dept = dept;
		this.gender = gender;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWork_location() {
		return work_location;
	}

	public void setWork_location(String work_location) {
		this.work_location = work_location;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employ [name=" + name + ", work_location=" + work_location + ", dept=" + dept + ", gender=" + gender
				+ "]";
	}
}
