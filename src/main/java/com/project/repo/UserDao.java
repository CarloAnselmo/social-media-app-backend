package com.project.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.model.Users;
import com.project.util.HibernateUtil;

public class UserDao implements DaoContract<Users, Integer> {

<<<<<<< HEAD
	
=======
>>>>>>> origin/main
	@Override
	public List<Users> findAll() {
		List<Users> uList = HibernateUtil.getSessionFactory().openSession().createNativeQuery("select * from users", Users.class).list();
		return uList;
	}
	
	@Override
	public Users findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
//		Transaction tx = sess.beginTransaction();
		Users u = sess.get(Users.class, i);
		return u;
	}

	@Override
	public Users update(Users t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(t);
		tx.commit();
		return t;
	}

	@Override
	public Users save(Users t) {
<<<<<<< HEAD
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
=======
//		//create blank profile before you add users
//		Profiles blank = new Profiles("no-pic", "I'm boring", "No bio", "No interests");
//		pDAO.save(blank);
		Session sess = HibernateUtil.getSessionFactory().openSession();
>>>>>>> origin/main
		Transaction tx = sess.beginTransaction();
		sess.persist(t);
		tx.commit();
		return t;
		
	}

	@Override
	public Users delete(Integer i) {
		//Session ses = HibernateUtil.getSessionFactory().openSession();
		//Needs to delete the profile first followed by the user
		//HQL
		//return ses.createQuery("delete from users where user_id ='"+i+"'", Users.class).getResultList().get(0);
		return null;
	}

}
