package com.guru.ecomspringboothibernate.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.ecomspringboothibernate.Dao.UserDao;
import com.guru.ecomspringboothibernate.entity.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public ArrayList<User> getUsers() {

		return userDao.getUserEntity();

	}

}
