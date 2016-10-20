package com.newer.login.bean;

import java.util.Date;
import java.util.List;


public class User {

	private String username;
	private String password;
	private Date birthday;
	private List<String> fav;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getFav() {
		return fav;
	}
	public void setFav(List<String> fav) {
		this.fav = fav;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	
	
}
