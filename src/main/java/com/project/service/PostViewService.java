package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.PostView;
import com.project.repo.PostViewDao;

@Service(value="postviewservice")
public class PostViewService {
	
	@Autowired
	private PostViewDao pvdao;
	
	public PostViewService() {
		super();
	}
	
	public PostViewService(PostViewDao pvdao) {
		super();
		this.pvdao = pvdao;
	}

	public PostViewDao getPvdao() {
		return pvdao;
	}

	public void setPvdao(PostViewDao pvdao) {
		this.pvdao = pvdao;
	}
	
	public List<PostView> getAllPostViews() {
		 List<PostView> list = pvdao.findAll();
		return list;
	}
	
	public List<PostView> getPostViewById(int userid) {
		List<PostView> list = pvdao.findByUserId(userid);
		return list;
	}
	
}
