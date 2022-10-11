package com.guru.ecomspringboothibernate.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.ecomspringboothibernate.Dao.UserDao;
import com.guru.ecomspringboothibernate.entity.Product;

@Service
public class ProductService {
    @Autowired
    UserDao userDao;

    public List<Product> getAllProducts() {
        Session session = userDao.getSession();
        Criteria criteria = session.createCriteria(Product.class);
        List<Product> list = criteria.list();
        return list;
    }

}
