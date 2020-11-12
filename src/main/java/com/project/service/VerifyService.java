package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repo.UserDao;
import com.project.repo.VerifyDao;

@Service(value="verifyservice")
public class VerifyService {

	@Autowired
	private VerifyDao vdao;

	@Autowired
	private UserDao udao;
	
	public VerifyService() {
		super();		
	}
	
	public String verifyUser(int code)
	{
		//check if the verification code exists in the db and if the used boolean is false
		
		//if used == false, then make it true...
		
		//...and update that user to be verified
		
		//if used == true, then don't do anything
		
		//redirect the user to the mochi site after processing
		
		return "We good";
	}
	
}
