package com.project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique=true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String firstname;
	
	@Column(nullable = false)
	private String lastname;
	
	@Column(nullable = false, unique=true)
	private String email;
	
	private String picUrl;
	
	private String status;
	
	private String bio;
	
	private String interests;
	
	// Relationship between users and posts
	@OneToMany(mappedBy="users", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Posts> posts;

	// If relationship was ManyToMany
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name = "likes",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name="post_id"))
	private Set<Posts> likedPosts;
	
//	@OneToMany(mappedBy = "user")
//	Set<Likes> likes;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

public Users(int id, String username, String password, String firstname, String lastname, String email, String picUrl,
		String status, String bio, String interests, Set<Posts> posts, Set<Posts> likedPosts) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.picUrl = picUrl;
	this.status = status;
	this.bio = bio;
	this.interests = interests;
	this.posts = posts;
	this.likedPosts = likedPosts;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPicUrl() {
	return picUrl;
}

public void setPicUrl(String picUrl) {
	this.picUrl = picUrl;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getBio() {
	return bio;
}

public void setBio(String bio) {
	this.bio = bio;
}

public String getInterests() {
	return interests;
}

public void setInterests(String interests) {
	this.interests = interests;
}

public Set<Posts> getPosts() {
	return posts;
}

public void setPosts(Set<Posts> posts) {
	this.posts = posts;
}

public Set<Posts> getLikedPosts() {
	return likedPosts;
}

public void setLikedPosts(Set<Posts> likedPosts) {
	this.likedPosts = likedPosts;
}

@Override
public String toString() {
	return "Users [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
			+ ", lastname=" + lastname + ", email=" + email + ", picUrl=" + picUrl + ", status=" + status + ", bio="
			+ bio + ", interests=" + interests + ", posts=" + posts + ", likedPosts=" + likedPosts + "]";
}
	
	


}
