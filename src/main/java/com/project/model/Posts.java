package com.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PostX")
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String post_text;
	
	@ManyToOne
	@JoinColumn(name="usersId", referencedColumnName="id")
	private Users users;
	
//	@ManyToMany(cascade = { CascadeType.ALL })
//	@JoinTable(
//	        name = "likes", 
//        joinColumns = { @JoinColumn(name = "id") }, 
//        inverseJoinColumns = { @JoinColumn(name = "id") }
//	        )
//	private Set<Posts> postsJoin = new HashSet<>();

	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Posts(int id, String post_text, Users users) {
		super();
		this.id = id;
		this.post_text = post_text;
		this.users = users;
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

	@Override
	public String toString() {
		return "Posts [id=" + id + ", post_text=" + post_text + "]";
	}
	
}
