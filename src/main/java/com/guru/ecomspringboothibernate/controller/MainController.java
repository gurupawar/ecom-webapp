package com.guru.ecomspringboothibernate.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.guru.ecomspringboothibernate.entity.User;
import com.guru.ecomspringboothibernate.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;

	
    @GetMapping("/hello")
    public String getHello() {
        System.out.println("hii");
        ArrayList<User> list = userService.getUsers();
        System.out.println(list);
        return "index";
    }
}
