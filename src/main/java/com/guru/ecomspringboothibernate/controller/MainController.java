package com.guru.ecomspringboothibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guru.ecomspringboothibernate.services.LoginService;
import com.guru.ecomspringboothibernate.services.RegisterService;
import com.guru.ecomspringboothibernate.services.UserService;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @Autowired
    RegisterService registerService;

    @GetMapping("/home")
    public String getAllPixxa() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/signup", method = RequestMethod.GET)
    public String signup() {
        return "signup";
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public String handleRegistration(@RequestParam("firstName") String Fname,
            @RequestParam("lastName") String Lname,
            @RequestParam("email") String email,
            @RequestParam("password") String password, Model model) {

        System.out.println("in ControllerClass HandleRegistration");
        registerService.handleReg(Fname, Lname, email, password, model);
        return "signup";
    }

    @RequestMapping(path = "/processlogin", method = RequestMethod.POST)
    public String handleLogin(@RequestParam("email") String email, @RequestParam("password") String password,
            Model model) {
        Boolean isValid = loginService.validatUser(email, password, model);

        if (isValid == true) {
            return "index";
        } else {
            return "LogRegerror";
        }
    }
}