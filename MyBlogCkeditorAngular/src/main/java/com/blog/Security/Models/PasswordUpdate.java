package com.blog.Security.Models;

import javax.persistence.Column;

public class PasswordUpdate {
    private Long id;
    private String userName;
	private String oledPassword;
    private String newPassword;
    
    
    
    public PasswordUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PasswordUpdate(Long id, String userName, String oledPassword, String newPassword) {
		super();
		this.id = id;
		this.userName = userName;
		this.oledPassword = oledPassword;
		this.newPassword = newPassword;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOledPassword() {
		return oledPassword;
	}
	public void setOledPassword(String oledPassword) {
		this.oledPassword = oledPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
