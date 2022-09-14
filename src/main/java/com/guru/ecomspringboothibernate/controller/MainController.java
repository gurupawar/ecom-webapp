package com.guru.ecomspringboothibernate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.guru.ecomspringboothibernate.Dao.CategoryDao;
import com.guru.ecomspringboothibernate.entity.Category;
import com.guru.ecomspringboothibernate.entity.User;
import com.guru.ecomspringboothibernate.services.LoginService;
import com.guru.ecomspringboothibernate.services.RegisterService;
import com.guru.ecomspringboothibernate.services.UserService;

import com.guru.ecomspringboothibernate.services.NewCategoryService;
import com.guru.ecomspringboothibernate.services.NewProductService;

@Controller
public class MainController {

	@Autowired
	UserService userService;

	@Autowired
	LoginService loginService;

	@Autowired
	RegisterService registerService;

	@Autowired
	NewCategoryService newCategoryService;

	@Autowired
	NewProductService newProductService;

	@Autowired
	CategoryDao categoryDao;

	@GetMapping("/home")
	public String getAllPixxa() {
		return "index";
	}

	@RequestMapping(path = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}

	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public ModelAndView handleRegistration(@RequestParam("firstName") String Fname,
			@RequestParam("lastName") String Lname, @RequestParam("email") String email,
			@RequestParam("password") String password, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("in ControllerClass HandleRegistration");
		registerService.handleReg(Fname, Lname, email, password, model);

		modelAndView.setViewName("signup");
		return modelAndView;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@GetMapping("/admin")
	public ModelAndView adminPanel() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin");
		return modelAndView;
	}

	@GetMapping("/normal")
	public ModelAndView normalPanel() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("normal");
		return modelAndView;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView handleLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		User user = loginService.validatUser(email, password, model);

		HttpSession httpSession = request.getSession();

		System.out.println(" in handleLogin method" + user);
		// String reDirect = null;

		if (user == null) {
			model.addAttribute("msg",
					"<div class='alert alert-warning' role='alert'> invalid email and password 😥 try again </div>");
			System.out.println("in null ");
			mv.setViewName("/login");
		} else {
			httpSession.setAttribute("current-user", user);
			System.out.println("current-user:-" + user);

			if (user.getU_type().equals("admin")) {
				System.out.println("in admin");
				List<Category> list = categoryDao.getCategories();
				System.out.println("lol" + list);
				mv.setViewName("admin");
			} else if (user.getU_type().equals("normal")) {
				System.out.println("in normal");
				mv.setViewName("/normal");
			}
		}
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logoutHandler(HttpServletRequest request) {
		System.out.println("in logout Handler method");
		HttpSession httpSession = request.getSession();
		ModelAndView mv = new ModelAndView();
		httpSession.removeAttribute("current-user");
		mv.setViewName("login");
		System.out.println("logged out");
		return mv;
	}

	// Add new Category
	@RequestMapping(path = "/addNewCategory", method = RequestMethod.POST)
	public ModelAndView addNewCategoryHandler(@RequestParam("categoryTitle") String catTitle,
			@RequestParam("categoryTitle") String catDesc, Model model) {
		System.out.println("in addNewCategoryHandler");
		ModelAndView mv = new ModelAndView();
		newCategoryService.newCategory(catTitle, catDesc, model);
		mv.setViewName("admin");
		CategoryDao cd = new CategoryDao();
		List<Category> l = cd.getCategories();
		System.out.println("categories - "+ l);
		return mv;
	}

	// Add new Product
	@RequestMapping(path = "/addNewProduct", method = RequestMethod.POST)
	public ModelAndView addNewProductHandler(@RequestParam("productTitle") String title,
			@RequestParam("productQty") String qty, @RequestParam("productPrice") String price,
			@RequestParam("productDesc") String desc, @RequestParam("productImage") String img, Model model) {
		System.out.println("in addNewProductHandler");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		newProductService.newProduct(title, qty, price, desc, img, model);
		return mv;
	}
}