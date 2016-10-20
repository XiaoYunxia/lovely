package com.newer.login.bean;

public class Staff {

	private int id;
	private String name;
	private String phone;
	private String email;
	private String job;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", job=" + job + "]";
	}
	public Staff(int id, String name, String phone, String email, String job) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.job = job;
	}
	public Staff() {
		super();
	}
	
	
}
