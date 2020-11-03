package com.project.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.model.Profiles;
import com.project.model.Users;
import com.project.util.HibernateUtil;

public class ProfilesDao implements DaoContract<Profiles, Integer> {

	@Override
	public List<Profiles> findAll() {
		List<Profiles> pList = HibernateUtil.getSessionFactory().openSession().createNativeQuery("select * from profiles", Profiles.class).list();
		return pList;
	}

	@Override
	public Profiles findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profiles update(Profiles t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(t);
		tx.commit();
		return t;
	}

	@Override
	public Profiles save(Profiles t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public Profiles delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}
}
