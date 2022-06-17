package com.blog.Security.Models;



public class PasswordUpdate {
    private Long id;
    private String userName;
	private String oldPassword;
    private String newPassword;
    
    
    
    
    
	public PasswordUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PasswordUpdate(Long id, String userName, String oldPassword, String newPassword) {
		super();
		this.id = id;
		this.userName = userName;
		this.oldPassword = oldPassword;
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
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
    
    
}