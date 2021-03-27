package com.example.UserService.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.UserService.model.Passcode;
import com.example.UserService.util.SessionFactory;

public class PasscodeRepository {
	public Passcode getPasscodeById(int id) {
		Passcode passcode = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = SessionFactory.getSession();
			tx = session.beginTransaction();
			passcode = session.get(Passcode.class, id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return passcode;
	}
}

