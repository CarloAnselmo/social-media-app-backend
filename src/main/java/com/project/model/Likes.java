package com.project.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name="LikeX")
public class Likes implements Serializable {
	
	
	private int user_id;
	
	
	private int post_id;


	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Likes(int user_id, int post_id) {
		super();
		this.user_id = user_id;
		this.post_id = post_id;
	}


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


	@Override
	public String toString() {
		return "Likes [user_id=" + user_id + ", post_id=" + post_id + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + post_id;
		result = prime * result + user_id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Likes other = (Likes) obj;
		if (post_id != other.post_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	
	

}
