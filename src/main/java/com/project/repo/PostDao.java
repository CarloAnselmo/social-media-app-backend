package com.project.repo;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Posts;

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
		List<Posts> pList = sessfact.getCurrentSession().createNativeQuery("select * from posts", Posts.class).list();
		return pList;
	}
	
	public int getNextPostId() {
		Query q = sessfact.getCurrentSession().createNativeQuery("select max(id) from social.posts");
		return (int) q.getSingleResult();
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
		Session sess = sessfact.getCurrentSession();
		sess.persist(t);
		return t;
	}

	public Posts delete(Posts t) {
		Session sess = sessfact.getCurrentSession();
		sess.delete(t);
		return t;
	}

	

}
