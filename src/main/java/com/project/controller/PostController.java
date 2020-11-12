package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.model.Posts;
import com.project.service.PostService;
import com.project.service.S3Service;
import com.project.service.UserService;

@Controller
@CrossOrigin // Injects the header, allows requests from this origin. Can also use wildcards
@RequestMapping("/posts")
public class PostController {
	
	private PostService ps;
	private UserService us;
	private S3Service s3s;

	public PostController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostController(PostService ps, UserService us, S3Service s3s) {
		super();
		this.ps = ps;
		this.us = us;
		this.s3s = s3s;
	}

	public PostService getPs() {
		return ps;
	}

	@Autowired
	public void setPs(PostService ps) {
		this.ps = ps;
	}
	
	public UserService getUs() {
		return us;
	}
	
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}
	
	public S3Service getS3s() {
		return s3s;
	}

	@Autowired
	public void setS3s(S3Service s3s) {
		this.s3s = s3s;
	}

	// Methods go here, remember to add mappings!
	@GetMapping
	public @ResponseBody List<Posts> getAll() {
		return ps.getAllPosts();
	}
	
	@GetMapping("/update/{userid}+{post_text}")
	public @ResponseBody Posts savePosts(@PathVariable int userid, @PathVariable String post_text) {
		Posts p = new Posts(0, post_text, us.findUserNoPass(userid), null, null);
		ps.savePosts(p);
		return p;
	}
	
	@PostMapping("/updatePhoto")
	public @ResponseBody Posts savePostsWithPhoto(@RequestParam("userid") int userid, 
			@RequestParam("postText") String postText, 
			@RequestParam("image") MultipartFile image) {
		String pic = null;
		if(image.getContentType().contains("image")) {
			pic = s3s.UploadAttachment(ps.getNextPostId().intValue(), image);
		}
		return ps.savePosts(new Posts(0, postText, us.findUserNoPass(userid), null, pic));
	}
}
