package com.guru.ecomspringboothibernate.Dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.ecomspringboothibernate.entity.Category;

@Service
public class CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	
	

}
