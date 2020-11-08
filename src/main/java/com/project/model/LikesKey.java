//package com.project.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//
//@Embeddable
//public class LikesKey implements Serializable {
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Column(name="user_id")
//	private int userId;
//	
//	@Column(name="post_id")
//	private int postId;
//
//
//	public LikesKey() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public LikesKey(int user_id, int post_id) {
//		super();
//		this.userId = user_id;
//		this.postId = post_id;
//	}
//
//
//	public int getUser_id() {
//		return userId;
//	}
//
//
//	public void setUser_id(int user_id) {
//		this.userId = user_id;
//	}
//
//
//	public int getPost_id() {
//		return postId;
//	}
//
//
//	public void setPost_id(int post_id) {
//		this.postId = post_id;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Likes [user_id=" + userId + ", post_id=" + postId + "]";
//	}
//
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + postId;
//		result = prime * result + userId;
//		return result;
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		LikesKey other = (LikesKey) obj;
//		if (postId != other.postId)
//			return false;
//		if (userId != other.userId)
//			return false;
//		return true;
//	}
//	
//	
//
//}
