package com.project.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Posts;
import com.project.model.Users;

@Repository
@Transactional
public class PostDao {
	
	private SessionFactory sessfact;
	
	public PostDao() {	}
	
	@Autowired
	public PostDao(SessionFactory sessfact) {
		super();
		this.sessfact = sessfact;
	}
	
	public List<Posts> findAll() {
		return sessfact.openSession().createQuery("from Posts", Posts.class).list();
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

	public Posts delete(Posts t) {
		Session sess = sessfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(t);
		tx.commit();
		return t;
	}

	

}
