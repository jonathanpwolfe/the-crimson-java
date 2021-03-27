package com.example.UserService.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.UserService.model.User;
import com.example.UserService.util.SessionFactory;

@Repository
public class UserRepository {

	public User getUserByUsername(String username) {
		User user = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = SessionFactory.getSession();
			tx = session.beginTransaction();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
			Root<User> root = criteriaQuery.from(User.class);
			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"), username));
			Query<User> query = session.createQuery(criteriaQuery);
			List<User> results = query.getResultList();
			if(!results.isEmpty()) {
				user = results.get(0);
			}
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return user;
	}
	public User getUserById(int id) {
		User user = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = SessionFactory.getSession();
			tx = session.beginTransaction();
			user = session.get(User.class, id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return user;
	}
	
	public void updateUser(User user) {
		Session session = null;
		Transaction tx = null;
		try {
			session = SessionFactory.getSession();
			tx = session.beginTransaction();
			session.merge(user);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}
	}
	public void insertUser(User user) {
		Session session = null;
		Transaction tx = null;
		try {
			session = SessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}
	}
}