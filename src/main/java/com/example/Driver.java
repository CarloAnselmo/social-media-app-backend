package com.example;

import java.util.HashSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.model.Users;
import com.project.repo.UserDao;

public class Driver {
	
	public static void main(String[] args) {
		
//		Users u2 = new Users(0, "big", "pass", "Pat", "Forty", "asdm@todfdfmmy.todm", "http://www.wow.com/", "happy", "I'm old", "I like to eat bugs", new HashSet<>(), new HashSet<>());
//		Posts p1 = new Posts(0, "wowowowowow", u1, new HashSet<>());
//		Posts p2 = new Posts(0, "tehthrhtrh", u1, new HashSet<>());
//		u.getPosts().add(p1);
//		u.getPosts().add(p2);
//		u.getPosts().add(p3);
		
//		PostDao pDAO = new PostDao();
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("testBeans.xml");
		UserDao uDAO = ac.getBean(UserDao.class);
		Users u1 = new Users(0, "tyj", "tyh", "rth", "rth", "hm@asd.asdm", "http://www.hm.com/", "qwe", "I'm qwe", "I qwe qwe stuff", new HashSet<>(), new HashSet<>());
//		uDAO.save(u1);
		System.out.println(uDAO.findAll());
//		System.out.println(uDAO.findByUsernamePass("ye", "ye"));
//		System.out.println(uDAO.findById(1));
		
//		uDAO.save(u2);
//		pDAO.save(p1);
//		pDAO.save(p2);
		
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beanConfig.xml");
//		UserService us = ac.getBean(UserService.class, "userservice");
//		ac.getBean(UserService.class);
//		ac.getBean(UserService.class);
//		ac.getBean(UserService.class);
//		ac.getBean(UserService.class);
//		System.out.println(us.getAllUsers());

	}
}
