package com.project.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Posts;
import com.project.model.Users;
import com.project.util.HibernateUtil;

public class PostDao implements DaoContract<Posts, Integer> {

	@Override
	public List<Posts> findAll() {
		List<Posts> pList = HibernateUtil.getSessionFactory().openSession().createNativeQuery("select * from users", Posts.class).list();
		return pList;
	}

	@Override
	public Posts findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Posts update(Posts t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Posts save(Posts t) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		sess.persist(t);
		tx.commit();
		return t;
	}

	@Override
	public Posts delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
