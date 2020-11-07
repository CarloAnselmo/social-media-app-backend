package com.project.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Posts;
import com.project.model.Users;
import com.project.util.HibernateUtil;

public class PostDao {

	public List<Posts> findAll() {
		List<Posts> pList = HibernateUtil.getSessionFactory().openSession().createNativeQuery("select * from users", Posts.class).list();
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
		Session sess = HibernateUtil.getSessionFactory().openSession();
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
