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
	
	public List<Users> findAll() {
		return sessfact.getCurrentSession().createQuery("from Users", Users.class).list();
	}
	
	public Users findById(int id) {
		return sessfact.getCurrentSession().get(Users.class, id);
	}
	
	public Users findByUsername(String username) {
		return sessfact.getCurrentSession().createQuery("from Users where username = '"+username+"'", Users.class).list().get(0);
	}
	
	public Users findByUsernamePass(String username, String pass) {
		
		Users testU = null;
		try {
			 testU = sessfact.getCurrentSession().createQuery("from Users where username = '"+username+"' "
					+ "and password = '"+pass+"'", Users.class).list().get(0);
		} catch(IndexOutOfBoundsException e)
		{
			testU = null;
			return testU;
		}
		
		return testU;
	}

	public Users update(Users t) {
		Session sess = sessfact.getCurrentSession();
		sess.update(t);
		//sess.close();
		return t;
	}
	
	public Users save(Users c) {
		Session sess = sessfact.getCurrentSession();
		sess.save(c);
		//sess.close();
		return c;
	}
	
	public Users delete(Integer i) {
		return null;
	}

}
