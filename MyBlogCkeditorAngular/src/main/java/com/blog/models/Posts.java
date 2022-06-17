package com.blog.models;



import java.util.Date;

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
	@Column(name = "cardContent")
	private String cardContent;
	
	@Column(name = "ceationDate")
	private Date ceationDate;	
	
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

	public String getCardContent() {
		return cardContent;
	}

	public void setCardContent(String cardContent) {
		this.cardContent = cardContent;
	}

	public Date getCeationDate() {
		return ceationDate;
	}

	public void setCeationDate(Date ceationDate) {
		this.ceationDate = ceationDate;
	}

	public Posts(Long id, String title, String cardContent, Date ceationDate, String statement, String imageLink,
			Long user_id) {
		super();
		this.id = id;
		Title = title;
		this.cardContent = cardContent;
		this.ceationDate = ceationDate;
		Statement = statement;
		this.imageLink = imageLink;
		User_id = user_id;
	}

	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}



	

}
