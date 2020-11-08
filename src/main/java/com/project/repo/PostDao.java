package com.project.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.model.Posts;
import com.project.model.Users;

public class PostDao {

	private SessionFactory sessfact;
	
	@Autowired
	public PostDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}
	
	public List<Posts> findAll() {
		List<Posts> pList = sessfact.openSession().createNativeQuery("select * from users", Posts.class).list();
		return pList;
	}

	public Posts findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Posts update(Posts t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Posts save(Posts t) {
		Session sess = sessfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.persist(t);
		tx.commit();
		return t;
	}

	public Posts delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
