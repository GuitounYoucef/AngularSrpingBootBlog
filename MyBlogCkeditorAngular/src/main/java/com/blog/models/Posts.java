package com.blog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Title")
	private String Title;

	@Lob
	@Column(name = "Statement")
	private String Statement;
	


	@Column(name = "imageLink")
	private String imageLink;

	@Column(name = "User_id")
	private Long User_id;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getStatement() {
		return Statement;
	}

	public void setStatement(String statement) {
		Statement = statement;
	}

	public Long getUser_id() {
		return User_id;
	}

	public void setUser_id(Long user_id) {
		User_id = user_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}


	public Posts(String title, String statement, String imageLink, Long user_id) {
		super();
		Title = title;
		Statement = statement;
		this.imageLink = imageLink;
		User_id = user_id;
	}

	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
