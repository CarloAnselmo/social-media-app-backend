package com.example;

import com.project.model.User;
import com.project.repo.UserDao;

public class Driver {
	
	public static void main(String[] args) {
		UserDao ud = new UserDao();
		User u1 = new User(0,"testman","wasspord","test","man","fake@email.com");
		ud.save(u1);
		System.out.println(ud.findAll());
//		System.out.println(td.findByName("ronald"));
	}

}
