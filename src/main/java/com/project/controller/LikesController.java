package com.project.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.Likes;
import com.project.service.LikesService;

@Controller
@CrossOrigin
@RequestMapping("/likes")
public class LikesController {

	private LikesService ls;
	
	public LikesController() {
		super();
	}
	
	public LikesController(LikesService ls) {
		super();
		this.ls = ls;
	}

	public LikesService getLs() {
		return ls;
	}

	@Autowired
	public void setLs(LikesService ls) {
		this.ls = ls;
	}
	
	@GetMapping
	public @ResponseBody List<Likes> getAll() {
		return ls.findAll();
	}
	
	@GetMapping("find/{post_id}")
	public @ResponseBody BigInteger findCountByPostId(@PathVariable int post_id) {
		return ls.findCountByPostId(post_id);
	}
	
	@GetMapping("status/{user_id}+{post_id}")
	public @ResponseBody BigInteger getLikeStatus(@PathVariable int user_id, @PathVariable int post_id) {
		return ls.getLikeStatus(user_id, post_id);
	}
	
	@GetMapping("update/{status}+{postid}+{userid}")
	public @ResponseBody Likes updateLikeStatus(@PathVariable boolean status, @PathVariable int postid, @PathVariable int userid) {
		Likes l = null;
		if(status) {
			l = ls.createLikes(new Likes(userid, postid));
		}
		else {
			l = ls.deleteLikes(new Likes(userid, postid));
		}
		return l;
	}
	
}
