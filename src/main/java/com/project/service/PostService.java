package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Users;
import com.project.repo.PostDao;
import com.project.repo.UserDao;

@Service(value="postservice")
public class PostService {

	@Autowired
	private PostDao pdao;

	public PostService() {
		super();
	}
	
	public PostService(PostDao pdao) {
		super();
		this.pdao = pdao;
	}
	
	public PostDao getPdao() {
		return pdao;
	}

	public void setPdao(PostDao pdao) {
		this.pdao = pdao;
	}

	// Methods go down here

}
