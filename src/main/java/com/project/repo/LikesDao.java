package com.project.repo;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Likes;

@Repository
@Transactional
public class LikesDao {

		private SessionFactory sessfact;
		
		public LikesDao() {}
		
		@Autowired
		public LikesDao(SessionFactory sessfact) {
			super();
			this.sessfact = sessfact;
		}
		
		public List<Likes> findAll() {
			return sessfact.getCurrentSession().createNativeQuery("select * from social.likes", Likes.class).list();
		}
		
		public BigInteger findCountByPostId(int post_id) {
			Query q = sessfact.getCurrentSession().createNativeQuery("select count(likes.user_id) from social.likes where post_id = ?1");
			q.setParameter(1, post_id);
			return (BigInteger) q.getSingleResult();
		}
		
		public List<Integer> findByUserId(int user_id) {
			return sessfact.getCurrentSession().createNativeQuery("select post_id from social.likes where user_id = " + user_id).list();
		}
		
		public BigInteger getLikeStatus(int user_id, int post_id) {
			Query q = sessfact.getCurrentSession().createNativeQuery("select count(*) from social.likes where user_id = ?1 and post_id = ?2");
			q.setParameter(1, user_id);
			q.setParameter(2, post_id);
			return  (BigInteger) q.getSingleResult();
		}
		
		public Likes update(Likes t) {
			Session sess = sessfact.getCurrentSession();
			Transaction tx = sess.beginTransaction();
			sess.update(t);
			tx.commit();
			return t;
		}
		
		public Likes save(Likes t) {
			Session sess = sessfact.getCurrentSession();
			Transaction tx = sess.beginTransaction();
			sess.save(t);
			tx.commit();
			return t;
		}
		
		public Likes delete(Likes t) {
			Session sess = sessfact.getCurrentSession();
			Transaction tx = sess.beginTransaction();
			sess.delete(t);
			tx.commit();
			return t;
		}
}
