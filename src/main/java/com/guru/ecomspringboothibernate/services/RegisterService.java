package com.guru.ecomspringboothibernate.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.guru.ecomspringboothibernate.Dao.UserDao;
import com.guru.ecomspringboothibernate.entity.User;

@Service
public class RegisterService {

    @Autowired
    UserDao userDao;

    public String handleReg(String fname, String lname, String email, String password, Model model) {
        System.out.println("in HandleReg method 'RegisterService'");

        Session session = userDao.getSession();
        Transaction tx = session.beginTransaction();

        User newUser = new User();
        newUser.setU_Fname(fname);
        newUser.setU_Lname(lname);
        newUser.setU_email(email);
        newUser.setU_pass(password);
        newUser.setU_type("normal");

        session.save(newUser);
        tx.commit();
        model.addAttribute("msg",
                "<div class='alert alert-success' role='alert'>Your account has been created successfully..🎉 <a href='login'>login</a></div>");
        session.clear();
        return null;
    }

}
