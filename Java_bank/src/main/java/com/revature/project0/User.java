package com.revature.project0;

public class User {
	private String userName;
	private String passWord;
	
	public User () { //constructor
		super();
	}
	
	public void setUserName (String u) {
		userName = u;
	}
	
	public String getUserName() {
		
		return userName;
	}
	
public void setPassWord (String p) {
		passWord = p;
	}
	
	public String getPassWord () {
		
		return passWord;
	}
}
