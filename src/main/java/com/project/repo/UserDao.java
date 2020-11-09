package com.project.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Users;

@Repository
@Transactional
public class UserDao {
	
	private SessionFactory sessfact;
	
	public UserDao() {	}
	
	@Autowired
	public UserDao(SessionFactory sessfact) {
		super();
		this.sessfact = sessfact;
	}

//	public List<Users> findAll() {
//		List<Users> uList = HibernateUtil.getSessionFactory().openSession().createNativeQuery("select * from users", Users.class).list();
//		return uList;
//	}
	
	public List<Users> findAll() {
		return sessfact.getCurrentSession().createQuery("from Users", Users.class).list();
	}
	
	public Users findById(int id) {
		return sessfact.getCurrentSession().get(Users.class, id);
	}
	
	public Users findByUsernamePass(String username, String pass) {
		return sessfact.getCurrentSession().createQuery("from Users where username = '"+username+"' and password = '"+pass+"'", Users.class).list().get(0);
	}

	public Users update(Users t) {
		Session sess = sessfact.getCurrentSession();
		sess.update(t);
		return t;
	}

//	public Users save(Users t) {
////		//create blank profile before you add users
////		Profiles blank = new Profiles("no-pic", "I'm boring", "No bio", "No interests");
////		pDAO.save(blank);
//		Session sess = HibernateUtil.getSessionFactory().openSession();
//		Transaction tx = sess.beginTransaction();
//		sess.persist(t);
//		tx.commit();
//		return t;
//	}
	
	public void save(Users c) {
//		sessfact.getCurrentSession().save(c);
		Session sess = sessfact.getCurrentSession();
		sess.save(c);
	}
	
	public Users delete(Integer i) {
		//Session ses = HibernateUtil.getSessionFactory().openSession();
		//Needs to delete the profile first followed by the user
		//HQL
		//return ses.createQuery("delete from users where user_id ='"+i+"'", Users.class).getResultList().get(0);
		return null;
	}

}
