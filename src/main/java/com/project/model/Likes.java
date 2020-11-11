package com.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="likes")

public class Likes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="user_id")
	private int user_id;

	@Id
	@Column(name="post_id")
	private int post_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public Likes(int user_id, int post_id) {
		super();
		this.user_id = user_id;
		this.post_id = post_id;
	}

	public Likes() {
		super();
	}

	@Override
	public String toString() {
		return "Likes [user_id=" + user_id + ", post_id=" + post_id + "]";
	}
	
	
}
