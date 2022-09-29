package com.guru.ecomspringboothibernate.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.guru.ecomspringboothibernate.Dao.UserDao;
import com.guru.ecomspringboothibernate.entity.Product;

@Service
public class NewProductService {
    @Autowired
    UserDao userDao;

    public void newProduct(String title, String qty, String price, String desc, MultipartFile img, String catId,
            Model model) {
        System.out.println("in newProduct Service method");
        Session session = userDao.getSession();
        Transaction tx = session.beginTransaction();

        Product newPro = new Product();
        newPro.setP_name(title);
        newPro.setP_quenty(qty);
        newPro.setP_price(price);
        newPro.setP_desc(desc);
        newPro.setP_photo(img.getOriginalFilename());

        int id = Integer.parseInt(catId);
        // newPro.setCategory(id);
        System.out.println("Category id" + id);

        session.save(newPro);
        System.out.println(newPro);
        tx.commit();
        model.addAttribute("cate_message",
                "<div class='alert alert-success alert-dismissible fade show' role='alert'>New product added successfully🎉 <button type='button' class='close' data-dismiss='alert' aria-label='Close'> <span aria-hidden='true'>&times;</span> </button> </div>");
    }
}
