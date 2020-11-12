package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Posts;
import com.project.repo.PostDao;

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
	
	public List<Posts> getAllPosts() {
		//return pdao.findAll();
		List<Posts> temp = pdao.findAll();
		for(Posts p : temp) {
			p.setUsers(null);
			p.setLikes(null);
		}
		return temp;
	}
	
	public Posts savePosts(Posts t) {
		return pdao.save(t);
	}
	
	public Posts deletePosts(Posts t) {
		return pdao.delete(t);
	}
}
