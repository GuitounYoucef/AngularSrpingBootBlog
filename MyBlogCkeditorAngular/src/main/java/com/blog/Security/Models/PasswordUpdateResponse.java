package com.blog.Security.Models;

public class PasswordUpdateResponse {
     private int responseCode;

     
     
	public PasswordUpdateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PasswordUpdateResponse(int i) {
		super();
		this.responseCode = i;
	}

	public int getResponseCode() {
		return this.responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
     
}
