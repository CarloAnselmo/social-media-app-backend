package com.project.repo;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
