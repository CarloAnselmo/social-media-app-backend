package com.project.run;

import com.project.model.Users;
import com.project.repo.UserDao;

public class Driver {
	
	public static void main(String[] args) {
		UserDao uDAO = new UserDao();
		
		Users u1 = new Users(0, "Dude", "secure", "Dingy", "Wingy", "dingywingus@gmail.com");
		Users u2 = new Users(0, "Shrude", "pass", "Shrewy", "Blewy", "shrewmydewd@gmail.com");
		
		uDAO.save(u1);
		uDAO.save(u2);
		System.out.println(uDAO.findAll());
	}

}
