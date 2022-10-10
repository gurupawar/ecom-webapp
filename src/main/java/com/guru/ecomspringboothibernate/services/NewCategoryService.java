package com.guru.ecomspringboothibernate.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.guru.ecomspringboothibernate.Dao.UserDao;
import com.guru.ecomspringboothibernate.entity.Category;

@Service
public class NewCategoryService {

    @Autowired
    UserDao userDao;

    public void newCategory(String catTitle, String catDesc, Model model) {
        System.out.println("in newCategory Service method");
        Session session = userDao.getSession();
        Transaction tx = session.beginTransaction();

        Category newCat = new Category();
        newCat.setC_name(catTitle);
        newCat.setC_desc(catDesc);

        session.save(newCat);
        tx.commit();
        model.addAttribute("cate_message",
                "<div class='alert alert-success alert-dismissible fade show' role='alert'>New category added successfully🎉 <button type='button' class='close' data-dismiss='alert' aria-label='Close'> <span aria-hidden='true'>&times;</span> </button> </div>");

    }

    public List<Category> getCategories() {
        Session session = userDao.getSession();
        Criteria criteria = session.createCriteria(Category.class);
        List<Category> clist = criteria.list();
        System.out.println(clist);
        return clist;
    }

    public Category getSingleCategory(String cId) {

        Category cat = null;
        try {
            Session session = userDao.getSession();
            cat = session.get(Category.class, cId);
            session.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return cat;
    }

}
