package com.blog.controllers;

public class UrlImage {
	private Boolean uploded;
	private String Name;
	private String url;
	public UrlImage(Boolean uploded, String name, String url) {
		super();
		this.uploded = uploded;
		Name = name;
		this.url = url;
	}
	public Boolean getUploded() {
		return uploded;
	}
	public void setUploded(Boolean uploded) {
		this.uploded = uploded;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	




}
