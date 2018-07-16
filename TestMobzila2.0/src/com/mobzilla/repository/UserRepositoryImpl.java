package com.mobzilla.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobzilla.entity.AddressBean;
import com.mobzilla.entity.ForgotBean;
import com.mobzilla.entity.LoginBean;
import com.mobzilla.entity.UserBean;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean registerUser(UserBean user, AddressBean address) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction txn = null;
		try {
			session = sessionFactory.getCurrentSession();
			txn = session.beginTransaction();
			session.save(user);
			session.save(address);
			txn.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}

	}

	@Override
	public Boolean validate(LoginBean login) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM UserBean where userEmail=:username AND userPass=:userpass";

		Transaction txn = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("username", login.getEmail());
		query.setParameter("userpass", login.getPassword());
		// String userName=query.toString();
		List list = query.list();
		txn.commit();
		System.out.println(login.getEmail() + " " + login.getPassword());
		/*
		 * if(userName!=null) return true; else return null;
		 */

		if (!list.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public String matchDetails(UserBean user) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		System.out.println("email contact----" + user.getUserContact());
		String hql = "FROM UserBean where userEmail= :useremail AND userContact= :usercontact";

		Transaction txn = session.beginTransaction();
		Query query = session.createQuery(hql);

		query.setParameter("useremail", user.getUserEmail());
		query.setParameter("usercontact", user.getUserContact());

		List<UserBean> list = query.list();

		txn.commit();

		if (!list.isEmpty())
			return list.get(0).getUserEmail();
		else
			return null;

	}

	@Override
	public boolean changePassword(ForgotBean bean) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE UserBean user SET user.userPass= :pass WHERE user.userEmail= :email";

		Transaction txn = session.beginTransaction();
		Query query = session.createQuery(hql);

		query.setParameter("pass", bean.getPassword1());
		query.setParameter("email", bean.getEmail());

		int res = query.executeUpdate();
		txn.commit();

		if (res != 0)
			return true;
		else
			return false;
	}

}
