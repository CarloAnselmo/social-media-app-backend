//package com.project.model;
//
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="LikeY")
//public class Likes {
//	
//	@EmbeddedId
//	LikesKey id;
//	
//	@ManyToOne
//	@MapsId("userId")
//	@JoinColumn(name="user_id")
//	private Users user;
//	
//	@ManyToOne
//	@MapsId("postId")
//	@JoinColumn(name="post_id")
//	private Posts post;
//
//	public Likes() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Likes(LikesKey id, Users user, Posts post) {
//		super();
//		this.id = id;
//		this.user = user;
//		this.post = post;
//	}
//
//	public LikesKey getId() {
//		return id;
//	}
//
//	public void setId(LikesKey id) {
//		this.id = id;
//	}
//
//	public Users getUser() {
//		return user;
//	}
//
//	public void setUser(Users user) {
//		this.user = user;
//	}
//
//	public Posts getPost() {
//		return post;
//	}
//
//	public void setPost(Posts post) {
//		this.post = post;
//	}
//	
//	
//
//}
