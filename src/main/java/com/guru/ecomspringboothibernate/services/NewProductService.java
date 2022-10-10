package com.guru.ecomspringboothibernate.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.guru.ecomspringboothibernate.Dao.UserDao;
import com.guru.ecomspringboothibernate.entity.Category;
import com.guru.ecomspringboothibernate.entity.Product;

@Service
public class NewProductService {
    @Autowired
    UserDao userDao;

    @Autowired
    NewCategoryService newCategoryService;

    public void newProduct(String title, String qty, String price, String desc, MultipartFile img, String catId,
            Model model, HttpServletRequest request) {
        System.out.println("in newProduct Service method");
        Session session = userDao.getSession();
        Transaction tx = session.beginTransaction();

        Product newPro = new Product();
        newPro.setP_name(title);
        newPro.setP_quenty(qty);
        newPro.setP_price(price);
        newPro.setP_desc(desc);
        newPro.setP_photo(img.getOriginalFilename());

        Category category = newCategoryService.getSingleCategory(catId);
        newPro.setCategory(category);

        System.out.println();

        session.save(newPro);
        System.out.println(newPro);

        // img Upload
        String path = request.getServletContext().getRealPath("images") + File.separator + "products" + File.separator
                + img.getOriginalFilename();

        // upload coding
        try {
            FileOutputStream fos = new FileOutputStream(path);
            InputStream is = img.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);

            // writting file
            fos.write(data);
            fos.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("path -" + path);
        System.out.println("product saved successfully...");
        tx.commit();
        session.close();
        model.addAttribute("cate_message",
                "<div class='alert alert-success alert-dismissible fade show' role='alert'>New product added successfully🎉 <button type='button' class='close' data-dismiss='alert' aria-label='Close'> <span aria-hidden='true'>&times;</span> </button> </div>");
    }
}
