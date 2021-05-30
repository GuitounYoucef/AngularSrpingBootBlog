package com.blog.models;



public class RegisterRequest {
	private String UserName;
	private String Userpassword;
	private String UserEmail;

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserpassword() {
		return Userpassword;
	}
	public void setUserpassword(String userpassword) {
		Userpassword = userpassword;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public RegisterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterRequest(String userName, String userpassword, String userEmail) {
		super();
		UserName = userName;
		Userpassword = userpassword;
		UserEmail = userEmail;
	}
	

}
