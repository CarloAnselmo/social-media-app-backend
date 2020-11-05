package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.Users;
import com.project.service.UserService;

@Controller
@RequestMapping(value = "/users.json", method = RequestMethod.POST, headers = "Content-Type=application/json")
public class UserController {

	private UserService uServ;

	public UserService getuServ() {
		return uServ;
	}
	
	@Autowired
	public void setuServ(UserService uServ) {
		this.uServ = uServ;
	}
	
	@GetMapping
	public @ResponseBody List<Users> getAllUsers()
	{
		return uServ.findAllUsers();
	}
	
	public Users getUserFromCred(String username, String password)
	{
		return uServ.getUser(username, password);
	}
	
}
