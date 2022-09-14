package com.guru.ecomspringboothibernate.Dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.ecomspringboothibernate.entity.Category;

@Service
public class CategoryDao {
    
	@Autowired
	SessionFactory sessionFactory;

//   public List<Category> getCategory(){
//	   List<Category> clist  = null;
//        try {
//        	  Session session = sessionFactory.openSession();
//        	  Query query = session.createQuery("from Category");
//        	  clist = query.list();    	
//        	
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        return clist;
//    }
   
   public List<Category> getCategories() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Category.class);
		List<Category> list= criteria.list();
		return list;
	}
}



