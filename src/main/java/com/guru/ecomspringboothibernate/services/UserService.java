package com.guru.ecomspringboothibernate.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guru.ecomspringboothibernate.Dao.UserDao;
import com.guru.ecomspringboothibernate.entity.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public String addNewUser(String firstName, String lastName, String password, String email, String id) {
		Session session = userDao.getSession();
		Transaction tx = session.beginTransaction();

		System.out.println("hii");
		User newUser = new User();

		newUser.setU_id(id);
		newUser.setU_Fname(firstName);
		newUser.setU_Lname(lastName);
		newUser.setU_pass(password);
		newUser.setU_email(email);

		System.out.println(newUser);
		session.save(newUser);
		tx.commit();
		// return "registration successfull..🎉";
		return null;

	}

}
