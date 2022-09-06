package com.guru.ecomspringboothibernate.Dao;

import java.util.ArrayList;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guru.ecomspringboothibernate.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		
		Session session = sessionFactory.openSession();
		return session;
	}
	
	public ArrayList<User> getUserEntity() {
		Criteria criteria= getSession().createCriteria(User.class);
		ArrayList<User> list = (ArrayList<User>) criteria.list();
		return list;
	}
}
