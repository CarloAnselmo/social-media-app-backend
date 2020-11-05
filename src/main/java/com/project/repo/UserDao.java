package com.project.repo;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.project.model.Users;
import com.project.util.HibernateUtil;

@Repository
public class UserDao implements DaoContract<Users, Integer> {


	@Override
	public List<Users> findAll() {
		List<Users> uList = HibernateUtil.getSessionFactory().openSession().createNativeQuery("select * from users", Users.class).list();
		return uList;
	}
	
	@Override
	public Users findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Users u = sess.get(Users.class, i);
		return u;
	}

	public Users findByCredentials(String username, String password)
	{
		Session ses = HibernateUtil.getSessionFactory().openSession();
		//Hibernate 3 way
//		SQLQuery q = sess.createSQLQuery("select * from users where username = :userN and password = :passW");
//		q.addEntity(Users.class);
//		q.setParameter("userN", username);
//		q.setParameter("passW", password);
//		return (Users)q.list().get(0);
		
		//HQL way
		return ses.createQuery("from users where username ='"+username+"' and password = '"+password+"'", 
				Users.class).getResultList().get(0);
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
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
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
