package com.guru.ecomspringboothibernate.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.guru.ecomspringboothibernate.entity.User;
import com.guru.ecomspringboothibernate.services.UserService;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String getAllPixxa() {
        ArrayList<User> list = userService.getUsers();
        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUp(User user) {
        System.out.println("signup");
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String login(@RequestParam String firstName, String lastName, String password, String email) {
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(password);

        return "login";
    }
}