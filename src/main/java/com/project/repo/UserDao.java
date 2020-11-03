package com.project.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.model.User;
import com.project.util.HibernateUtil;

public class UserDao implements DaoContract<User, Integer> {

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();	// Open up a transaction block, perform operation, then commit
		sess.save(t);		// Since we've already told hibernate the mappings, it should know how to do this part
		tx.commit();
		return t;
	}

	@Override
	public User delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

}
