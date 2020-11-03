package com.example;

import java.util.HashSet;

import com.project.model.Posts;
import com.project.model.Users;
import com.project.repo.UserDao;

public class Driver {
	
	public static void main(String[] args) {
		
		Users u = new Users(0, "cool", "secure", "Tom", "Leonard", "tom@tommy.tom", "http://www.butt.com/", "bored", "I'm cool", "I like cool stuff", new HashSet<>());
		Posts p1 = new Posts(0, "wowowowowow", u);
		Posts p2 = new Posts(0, "tehthrhtrh", u);
		Posts p3 = new Posts(0, "kyuyukyukyuk", u);
		u.getPosts().add(p1);
		u.getPosts().add(p2);
		u.getPosts().add(p3);
		
		UserDao uDAO = new UserDao();
		uDAO.save(u);
		System.out.println(uDAO.findById(1));

	}
}
