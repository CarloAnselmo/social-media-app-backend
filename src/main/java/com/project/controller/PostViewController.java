package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.PostView;
import com.project.service.PostViewService;

@Controller
@CrossOrigin
@RequestMapping("/postview")
public class PostViewController {
	
	private PostViewService pvs;

	public PostViewController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostViewController(PostViewService pvs) {
		super();
		this.pvs = pvs;
	}

	public PostViewService getPvs() {
		return pvs;
	}

	@Autowired
	public void setPvs(PostViewService pvs) {
		this.pvs = pvs;
	}
	
	@GetMapping
	public @ResponseBody List<PostView> getAll() {
		return pvs.getAllPostViews();
	}
	
	@GetMapping("find/{userid}")
	public @ResponseBody List<PostView> getById(@PathVariable int userid) {
		return pvs.getPostViewById(userid);
	}
	
	
}
