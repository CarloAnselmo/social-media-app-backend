package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.project.model.Users;
import com.project.repo.UserDao;

@Service(value="userservice")
public class UserService {

	@Autowired
	private UserDao udao;

	public UserService() {
		super();
	}
	
	public UserService(UserDao udao) {
		super();
		this.udao = udao;
	}
	
	public UserDao getUdao() {
		return udao;
	}

	public void setUdao(UserDao udao) {
		this.udao = udao;
	}

	public List<Users> getAllUsers() {
		List<Users> temp = udao.findAll();
		for(Users u : temp) {
			u.setEmail(null);
			u.setPassword(null);
			u.setPosts(null);
			u.setLikedPosts(null);
		}
		return temp;
	}
	
	public Users findUserNoPass(int id) {
		Users temp = udao.findById(id);
		temp.setEmail(null);
		temp.setUsername(null);
		temp.setPassword(null);
		temp.setPosts(null);
		temp.setLikedPosts(null);
		return temp;
	}
	
	public Users validateLogin(String username, String pass) {
		Users temp = udao.findByUsernamePass(username, pass);
		temp.setPassword(null);
		temp.setPosts(null);
		temp.setLikedPosts(null);
		return temp;
	}

}
