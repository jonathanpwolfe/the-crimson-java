package com.example.PostService.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Post {
	@Id
	@Column(name = "")
	private int postId;
	@Column(name = "")
	private int threadId;
	@Column(name = "")
	private int userId;
	@Column(name = "")
	private Date postDate;
	@Column(name = "")
	private int upvotes;
	@Column(name = "")
	private int downvotes;
	@Column(name = "")
	private int totalKarma;
	@Column(name = "")
	private String content;
	
	

}
