package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repo.LikesDao;

import com.project.model.Likes;

@Service(value="likesservice")
public class LikesService {

	@Autowired
	private LikesDao ld;
	
	public LikesService() {
		super();
	}
	
	public LikesService(LikesDao ld) {
		this.ld = ld;
	}

	public LikesDao getLd() {
		return ld;
	}

	public void setLd(LikesDao ld) {
		this.ld = ld;
	}
	
	public List<Likes> findAll() {
		return ld.findAll();
	}
	
	public int findCountByPostId(int post_id) {
		return ld.findCountByPostId(post_id);
	}
	
	public Likes createLikes(Likes t) {
		return ld.save(t);
	}
	
	public Likes deleteLikes(Likes t) {
		return ld.delete(t);
	}
}
