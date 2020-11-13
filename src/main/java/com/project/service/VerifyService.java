package com.project.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.project.model.Users;
import com.project.model.Verify;
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
		Verify testV = vdao.findByCode(code);
		
		System.out.println("test object:" + testV.toString());
		//if used == false, then make that verify row == true..
		if(testV != null)
		{
			Verify updatedVerify = new Verify(code, testV.getUserId(), true);
			vdao.update(updatedVerify);
			
			// ...and update that particular user to be verified
			Users verifUser = udao.findById(testV.getUserId());
			verifUser.setVerified(true);
			udao.update(verifUser);
			
			//redirect the user to the mochi site after processing
			new RedirectView("http://localhost:3000/spin");
			return "**User verified!**";
		}
		else
		{
			new RedirectView("http://localhost:3000/spin");
			return "ERROR: Verification code has either been used or is invalid";
		}
		
		
	}
	
}
