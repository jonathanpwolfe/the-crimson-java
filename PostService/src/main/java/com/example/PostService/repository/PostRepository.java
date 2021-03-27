package com.example.PostService.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.example.PostService.util.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.example.PostService.model.Post;

@Repository
public class PostRepository {

	public Post getPostById(int id) {
		Post post = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = SessionFactory.getSession();
			tx = session.beginTransaction();
			post = session.get(Post.class, id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return post;
	}
}
