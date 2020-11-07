package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.repo.PostDao;
import com.project.repo.UserDao;
import com.project.service.UserService;

public class Driver {
	
	public static void main(String[] args) {
		
//		Users u1 = new Users(0, "asd", "asd", "asd", "asd", "tom@asd.asdm", "http://www.butt.com/", "bored", "I'm cool", "I like cool stuff", new HashSet<>(), new HashSet<>());
//		Users u2 = new Users(0, "big", "pass", "Pat", "Forty", "asdm@todfdfmmy.todm", "http://www.wow.com/", "happy", "I'm old", "I like to eat bugs", new HashSet<>(), new HashSet<>());
//		Posts p1 = new Posts(0, "wowowowowow", u1, new HashSet<>());
//		Posts p2 = new Posts(0, "tehthrhtrh", u1, new HashSet<>());
//		u.getPosts().add(p1);
//		u.getPosts().add(p2);
//		u.getPosts().add(p3);
		
		UserDao uDAO = new UserDao();
		PostDao pDAO = new PostDao();
//		uDAO.save(u1);
//		uDAO.save(u2);
//		pDAO.save(p1);
//		pDAO.save(p2);
		
		System.out.println(uDAO.findById(1));
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beanConfig.xml");
		UserService us = ac.getBean(UserService.class, "userservice");
		ac.getBean(UserService.class);
		ac.getBean(UserService.class);
		ac.getBean(UserService.class);
		ac.getBean(UserService.class);
		System.out.println(us.getAllUsers());

	}
}
