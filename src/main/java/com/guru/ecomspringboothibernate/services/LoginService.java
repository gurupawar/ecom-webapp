package com.guru.ecomspringboothibernate.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.guru.ecomspringboothibernate.Dao.UserDao;
import com.guru.ecomspringboothibernate.entity.User;

@Service
public class LoginService {

    @Autowired
    UserDao userDao;

    public boolean validatUser(String email, String password, Model model) {

        ArrayList<User> list = userDao.getUsers();
        boolean isUservalid = false;

        for (User e : list) {
            if (e.getU_email().equals(email) && e.getU_pass().equals(password)) {
                model.addAttribute("message", "successfull Login 🎉");
                isUservalid = true;
            } else {
                model.addAttribute("message", "please enter correct email and password😥");
            }
        }

        return isUservalid;
    }

}
