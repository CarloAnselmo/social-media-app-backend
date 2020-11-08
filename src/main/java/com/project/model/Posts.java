package com.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String post_text;
	
	// Relationship between users and posts
	@ManyToOne
	@JoinColumn(name="usersId", referencedColumnName="id")
	private Users users;
	
	// If posts and users were many-to-many
	@ManyToMany(mappedBy = "likedPosts")
	private Set<Users> likes;
	
//	@OneToMany(mappedBy = "post")
//	Set<Likes> likes;

	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}

public Posts(int id, String post_text, Users users, Set<Users> likes) {
	super();
	this.id = id;
	this.post_text = post_text;
	this.users = users;
	this.likes = likes;
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

public Users getUsers() {
	return users;
}

public void setUsers(Users users) {
	this.users = users;
}

public Set<Users> getLikes() {
	return likes;
}

public void setLikes(Set<Users> likes) {
	this.likes = likes;
}

@Override
public String toString() {
	return "Posts [id=" + id + ", post_text=" + post_text + "]";
}

	
	
}
