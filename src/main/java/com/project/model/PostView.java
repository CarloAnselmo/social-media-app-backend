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

	@Column(name="post_userid")
	int post_userid;
	
	@Column(name="post_firstname")
	String post_firstname;
	
	@Column(name="post_lastname")
	String post_lastname;
	
	@Column(name="post_username")
	String post_username;
	
	@Column(name="post_picurl")
	String post_picurl;
	
	@Id //id for individual post, not to be confused with userid
	@Column(name="id")
	int id;
	
	@Column(name="post_text")
	String post_text;
	
	@Column(name="image")
	String image;
	
	@Column(name="likes")
	int likes;

	public int getPost_userid() {
		return post_userid;
	}

	public void setPost_userid(int post_userid) {
		this.post_userid = post_userid;
	}

	public String getPost_firstname() {
		return post_firstname;
	}

	public void setPost_firstname(String post_firstname) {
		this.post_firstname = post_firstname;
	}

	public String getPost_lastname() {
		return post_lastname;
	}

	public void setPost_lastname(String post_lastname) {
		this.post_lastname = post_lastname;
	}

	public String getPost_username() {
		return post_username;
	}

	public void setPost_username(String post_username) {
		this.post_username = post_username;
	}

	public String getPost_picurl() {
		return post_picurl;
	}

	public void setPost_picurl(String post_picurl) {
		this.post_picurl = post_picurl;
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

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public PostView(int post_userid, String post_firstname, String post_lastname, String post_username,
			String post_picurl, int id, String post_text, String image, int likes) {
		super();
		this.post_userid = post_userid;
		this.post_firstname = post_firstname;
		this.post_lastname = post_lastname;
		this.post_username = post_username;
		this.post_picurl = post_picurl;
		this.id = id;
		this.post_text = post_text;
		this.image = image;
		this.likes = likes;
	}

	public PostView() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PostView [post_userid=" + post_userid + ", post_firstname=" + post_firstname + ", post_lastname="
				+ post_lastname + ", post_username=" + post_username + ", post_picurl=" + post_picurl + ", id=" + id
				+ ", post_text=" + post_text + ", image=" + image + ", likes=" + likes + "]";
	}
	
}
