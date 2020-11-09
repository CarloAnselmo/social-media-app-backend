package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin // Injects the header, allows requests from this origin. Can also use wildcards
@RequestMapping("/posts")
public class PostController {
	
	private PostController pc;

	public PostController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostController(PostController pc) {
		super();
		this.pc = pc;
	}

	public PostController getPc() {
		return pc;
	}

	public void setPc(PostController pc) {
		this.pc = pc;
	}
	
	// Methods go here, remember to add mappings!
	
}
