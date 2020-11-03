package com.project.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.model.Profiles;
import com.project.model.Users;
import com.project.util.HibernateUtil;

public class UserDao implements DaoContract<Users, Integer> {

	private static ProfilesDao pDAO = new ProfilesDao();
	
	@Override
	public List<Users> findAll() {
		List<Users> uList = HibernateUtil.getSessionFactory().openSession().createNativeQuery("select * from users", Users.class).list();
		return uList;
	}
	
	@Override
	public Users findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
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
		//create blank profile before you add users
		Profiles blank = new Profiles("no-pic", "I'm boring", "No bio", "No interests");
		pDAO.save(blank);
		
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
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
