package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> f277b739f40939127e7de9b98634f5a5765ce729
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.Users;
import com.project.service.UserService;

@Controller
<<<<<<< HEAD
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
	
=======
@CrossOrigin // Injects the header, allows requests from this origin. Can also use wildcards
@RequestMapping("/users.app")
public class UserController {
	
	private UserService us;
	
	public UserController() {
	}

	public UserController(UserService us) {
		super();
		this.us = us;
	}
	
	public UserService getUsers() {
		return us;
	}

	@Autowired
	public void setPps(UserService us) {
		this.us = us;
	}

	@GetMapping
	public @ResponseBody List<Users> getAll() {
		return us.getAllUsers();
	}

>>>>>>> f277b739f40939127e7de9b98634f5a5765ce729
}
