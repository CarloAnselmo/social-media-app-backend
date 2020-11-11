package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.Posts;
import com.project.service.PostService;
<<<<<<< HEAD
=======
import com.project.service.UserService;
>>>>>>> origin/main

@Controller
@CrossOrigin // Injects the header, allows requests from this origin. Can also use wildcards
@RequestMapping("/posts")
public class PostController {
	
	private PostService ps;
<<<<<<< HEAD
=======
	private UserService us;
>>>>>>> origin/main

	public PostController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostController(PostService ps) {
		super();
		this.ps = ps;
	}

	public PostService getPs() {
		return ps;
	}

	@Autowired
	public void setPs(PostService ps) {
		this.ps = ps;
<<<<<<< HEAD
=======
	}
	
	public UserService getUs() {
		return us;
	}
	
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
>>>>>>> origin/main
	}
	
	// Methods go here, remember to add mappings!
	@GetMapping
	public @ResponseBody List<Posts> getAll() {
		return ps.getAllPosts();
	}
	
	@GetMapping("update/{userid}+{post_text}")
	public @ResponseBody Posts savePosts(@PathVariable int userid, @PathVariable String post_text) {
<<<<<<< HEAD
		return null;
		//TODO implement creation of posts
=======
		Posts p = new Posts(0, post_text, us.findUserNoPass(userid), null);
		ps.savePosts(p);
		return p;
>>>>>>> origin/main
	}
}
