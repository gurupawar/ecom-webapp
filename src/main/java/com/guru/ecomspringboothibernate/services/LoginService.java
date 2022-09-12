package com.guru.ecomspringboothibernate.services;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.guru.ecomspringboothibernate.Dao.UserDao;
import com.guru.ecomspringboothibernate.entity.User;

@Service
public class LoginService {

    @Autowired
    UserDao userDao;

    public User validatUser(String email, String password, Model model) {

        // ArrayList<User> list = userDao.getUsers();
        // boolean isUservalid = false;


        // for (User e : list) {
        //     if (e.getU_email().equals(email) && e.getU_pass().equals(password)) {
        //         model.addAttribute("message", "successfull Login 🎉");
        //         isUservalid = true;
        //     } else {
        //         model.addAttribute("message", "please enter correct email and password😥");
        //     }
        // }

        // return isUservalid;

        User user = null;
        try {
             String query = "from User where u_email=: e and u_pass=: p";
             Session session = userDao.getSession();
             Query q = session.createQuery(query);
             q.setParameter("e", email);
             q.setParameter("p", password);
             user = (User) q.uniqueResult();

             session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
