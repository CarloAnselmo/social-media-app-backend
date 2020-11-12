package com.project.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.model.Users;
import com.project.service.S3Service;
import com.project.service.UserService;


@Controller
@CrossOrigin(origins="http://localhost:3000") // Injects the header, allows requests from this origin. Can also use wildcards
@RequestMapping("/users")
@MultipartConfig
public class UserController {

	private UserService us;
	private S3Service s3s;

	public UserController() {
	}

	public UserController(UserService us, S3Service s3s) {
		super();
		this.us = us;
		this.s3s = s3s;
	}

	public UserService getUsers() {
		return us;
	}

	@Autowired
	public void setPps(UserService us) {
		this.us = us;
	}

	@Autowired
	public void setS3s(S3Service s3s) {
		this.s3s = s3s;
	}

	@GetMapping
	public @ResponseBody List<Users> getAll() {
		return us.getAllUsers();
	}

	@GetMapping("/find/{id}")
	public @ResponseBody Users findUserNoPass(@PathVariable int id) {
		return us.findUserNoPass(id);
	}

	@PostMapping(value="/validate")
	public @ResponseBody Users validateUser(@RequestBody Map<String, String> json) {
		
		return us.validateLogin(json.get("username"), json.get("password"));
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody Users createUser(@RequestBody Map<String, String> json) 
	{
		return us.createUser(json.get("username"), json.get("password"), json.get("firstname"), 
				json.get("lastname"), json.get("email"));
	}

	@PostMapping(value="/status")
	public @ResponseBody String updateStatus(@RequestBody Map<String, String> json) {
		System.out.println(json);
		int userId = Integer.parseInt(json.get("userId"));
		String status = json.get("status");
		return us.updateUserStatus(userId, status);
	}

	@PostMapping("/updateBasic")
	public @ResponseBody Users updateBasicInfo(@RequestParam("userId") int userId,
			@RequestParam("image") MultipartFile image, @RequestParam("username") String username,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("bio") String bio, @RequestParam("interests") String interests) {
		
		String pic = "";
		if (image.getContentType().contains("image")) {
			pic = s3s.UploadAvatar(userId, image);
		}
		
		Users temp = new Users();
		temp.setId((userId));
		temp.setUsername(username);
		temp.setFirstname(firstName);
		temp.setLastname(lastName);
		temp.setBio(bio);
		temp.setInterests(interests);
		temp.setPicUrl(pic);

		Users removeRecursion = us.updateBasicInfo(temp);
		removeRecursion.setPosts(null);
		removeRecursion.setLikedPosts(null);
		return removeRecursion;
	}

	@PostMapping("/updatePic")
	public @ResponseBody Users updateProfilePic(@RequestParam("userId") int userId,
			@RequestParam("image") MultipartFile image) {
		String pic = "";
		if (image.getContentType().contains("image")) {
			pic = s3s.UploadAvatar(userId, image);
		}

		Users removeRecursion = us.updateProfilePic(userId, pic);
		removeRecursion.setPosts(null);
		removeRecursion.setLikedPosts(null);
		return removeRecursion;
	}

	// This one will probably need to be changed when email feature is added
	@PostMapping("/updateEmail")
	public @ResponseBody Users updateEmail(@RequestBody Map<String, String> json) {
		int userId = Integer.parseInt(json.get("userId"));
		String email = json.get("email");

		// LOGIC TO SEND EMAIL GOES HERE

		Users removeRecursion = us.updateEmail(userId, email);
		removeRecursion.setPosts(null);
		removeRecursion.setLikedPosts(null);
		return removeRecursion;
	}

	// This one will probably need to be changed when email feature is added
	@PostMapping("/update")
	public @ResponseBody Users updatePassword(@RequestBody Map<String, String> json) {
		int userId = Integer.parseInt(json.get("userId"));
		String password = json.get("password");

		// LOGIC TO SEND EMAIL GOES HERE

		Users removeRecursion = us.updatePassword(userId, password);
		removeRecursion.setPosts(null);
		removeRecursion.setLikedPosts(null);
		return removeRecursion;
	}

}
