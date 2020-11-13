package com.project.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Users;
import com.project.model.Verify;

@Repository
@Transactional
public class VerifyDao {

	private SessionFactory sessfact;

	@Autowired
	public VerifyDao(SessionFactory sessfact) {
		super();
		this.sessfact = sessfact;
	}
	
	public List<Verify> findAll() {
		return sessfact.getCurrentSession().createQuery("from Verify", Verify.class).list();
	}
	
	public Verify findByCode(int code) {
		
		Verify ver = null;
		try {
			 ver = sessfact.getCurrentSession().createQuery("from Verify where code = "+code+" "
					+ "and used = false", Verify.class).list().get(0);
		}catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
			ver = null;
		}
		
		return  ver;
	}
	
	public boolean save(Verify v) {
		Session sess = sessfact.getCurrentSession();
		try {
			sess.save(v);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Verify update(Verify v) {
		Session sess = sessfact.getCurrentSession();
		sess.update(v);
		return v;
	}
	
	
	
}
