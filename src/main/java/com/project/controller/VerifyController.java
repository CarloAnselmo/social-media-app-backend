package com.project.controller;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.service.VerifyService;


@Controller
@CrossOrigin(origins="http://localhost:3000") // Injects the header, allows requests from this origin. Can also use wildcards
@RequestMapping("/verify")
@MultipartConfig
public class VerifyController {

	private VerifyService vs;
	
	@Autowired
	public void setPps(VerifyService vs) {
		this.vs = vs;
	}

	@RequestMapping(value={"/{code}"}, method=RequestMethod.GET)
	public @ResponseBody String verifyUser(@PathVariable(value="code") int code) {
		return vs.verifyUser(code);
	}
}
