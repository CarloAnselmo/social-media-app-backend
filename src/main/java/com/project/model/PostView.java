package com.project.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

/*
 * You may be wondering "Why does this post view exist
 * 	when we already have a post object?" Well, to display
 * a post on the front end, we need information from both
 * the user table and the post table. If we were to add this
 * info to the post table, we would simply be repeating information
 * already held in the user table. Thus a view with a few columns
 * from both tables is needed.
 */
@Entity
@Immutable
@Table(name="social.post_view", schema="social")
public class PostView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="userid")
	int userid;
	
	@Column(name="username")
	String username;
	
	@Column(name="picurl")
	String picurl;
	
	@Id //id for individual post, not to be confused with userid
	@Column(name="id")
	int id;
	
	@Column(name="post_text")
	String post_text;
	
	@Column(name="image")
	String image;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPost_text() {
		return post_text;
	}

	public void setPost_text(String post_text) {
		this.post_text = post_text;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public PostView(int userid, String username, String picurl, int id, String post_text, String image) {
		super();
		this.userid = userid;
		this.username = username;
		this.picurl = picurl;
		this.id = id;
		this.post_text = post_text;
		this.image = image;
	}

	public PostView() {
		super();
	}

	@Override
	public String toString() {
		return "PostView [userid=" + userid + ", username=" + username + ", picurl=" + picurl + ", id=" + id
				+ ", post_text=" + post_text + ", image=" + image + "]";
	}
	
}
