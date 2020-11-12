package com.project.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.aop.Loggers;
import com.project.model.Users;
import com.project.service.EmailService;
import com.project.service.S3Service;
import com.project.service.UserService;

@Controller
@CrossOrigin(origins = "http://localhost:3000") // Injects the header, allows requests from this origin. Can also use
												// wildcards
@RequestMapping("/users")
@MultipartConfig
public class UserController {
	
	final static Logger logger = Logger.getLogger(UserController.class);

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

	@PostMapping("/validate")
	public @ResponseBody Users validateUser(@RequestBody Map<String, String> json) {
		return us.validateLogin(json.get("username"), json.get("password"));
	}

	@PostMapping("/create")
	public @ResponseBody Users createUser(@RequestBody Map<String, String> json) {
		return us.createUser(json.get("username"), json.get("password"), json.get("firstname"), json.get("lastname"),
				json.get("email"));
	}

	@PostMapping("/status")
	public @ResponseBody String updateStatus(@RequestBody Map<String, String> json) {
		System.out.println(json);
		int userId = Integer.parseInt(json.get("userId"));
		String status = json.get("status");
		return us.updateUserStatus(userId, status);
	}

	@PostMapping(value = "/updateBasic")
	public @ResponseBody Users updateBasicInfo(@RequestParam("userId") int userId,
			@RequestParam(name = "image", required = false) MultipartFile image,
			@RequestParam("username") String username, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("bio") String bio,
			@RequestParam("interests") String interests) {

		String pic = "";
		Users temp = new Users();

		if (image == null) {
			// Do nothing
		} else if (image.getContentType().contains("image")) {
			pic = s3s.UploadAvatar(userId, image);
			temp.setPicUrl(pic);
		}

		temp.setId((userId));
		temp.setUsername(username);
		temp.setFirstname(firstName);
		temp.setLastname(lastName);
		temp.setBio(bio);
		temp.setInterests(interests);

		Users removeRecursion = us.updateBasicInfo(temp);
		removeRecursion.setPassword(null);
		removeRecursion.setPosts(null);
		removeRecursion.setLikedPosts(null);
		return removeRecursion;
	}

	// This one will probably need to be changed when email feature is added
	@PostMapping("/updateEmail")
	public @ResponseBody Users updateEmail(@RequestBody Map<String, String> json) {
		int userId = Integer.parseInt(json.get("userId"));
		String email = json.get("email");
		String oldEmail = json.get("oldEmail");

		EmailService.sendMail(oldEmail, "Your MochiCircle email has been updated",
				"<p>Just letting you know that your MochiCircle email has been changed to " + email
						+ "!</p><br/><p>If you did not request this change, that's too bad!</p>");
		EmailService.sendMail(email, "Your new MochiCircle email", "<p>Hey!\nYour account that was previously tied to "
				+ oldEmail
				+ " has been moved to this email address!</p><br/><p>If you did not make this request, that's too bad!</p>");

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
		String email = json.get("email");
		String firstLetter = password.substring(0, 1);

		EmailService.sendMail(email, "Your MochiCircle password has changed",
				"<p>Just letting you know that your MochiCircle password has been changed to something beginning with the character '"
						+ firstLetter + "'!</p><br/><p>If you did not request this change, good luck!</p>");

		Users removeRecursion = us.updatePassword(userId, password);
		removeRecursion.setPosts(null);
		removeRecursion.setLikedPosts(null);
		return removeRecursion;
	}

}
