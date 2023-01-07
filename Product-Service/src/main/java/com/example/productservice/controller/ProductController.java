package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.entity.User;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    UserRestConsumer consumer;
    @RequestMapping("/login")
    public boolean userLogin(@RequestBody User user, HttpSession session){
       boolean userValidated = consumer.userLogin(user);
       if(userValidated){
           session.setAttribute(user.getUsername(), user.getUsername());
       }
       return userValidated;
    }

    @RequestMapping("/adminLogin")
    public boolean adminLogin(@RequestBody User user, HttpSession session){
        boolean adminValidated = consumer.adminLogin(user);
        if(adminValidated){
            session.setAttribute(user.getUsername(), user.getUsername());
        }
        return adminValidated;
    }
    @RequestMapping("/signup")
    public void userSignUp(@RequestBody User user){
        consumer.userSignUp(user);
    }
    @RequestMapping("/all")
    private List<Product> getAllProducts(@RequestBody User user, HttpServletRequest request){
        if(request.getSession().getAttribute(user.getUsername())!=null) {
            return productService.findAllProducts();
        }
        return new ArrayList<>();
    }
    @RequestMapping("/logout")
    private void userLogout(@RequestBody User user, HttpServletRequest request){
       request.getSession().removeAttribute(user.getUsername());
    }
    //creating a get mapping that retrieves the detail of a specific student
    @RequestMapping("/{id}")
    private Product getProduct(@RequestBody User user,HttpServletRequest request, @PathVariable("id") int id)
    {
        if(request.getSession().getAttribute(user.getUsername())!=null) {
            return productService.findProductById(id);
        }
        return new Product();
    }
    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/{id}")
    private void deleteProduct(@RequestBody User user,HttpServletRequest request, @PathVariable("id") int id)
    {
        if(request.getSession().getAttribute(user.getUsername())!= null && user.getRole().equals("ADMIN")) {
            productService.deleteProduct(id);
        }
    }
    //creating post mapping that post the student detail in the database
    @PostMapping("/student")
    private int saveProduct(@RequestBody User user, HttpServletRequest request, @RequestBody Product product)
    {
        if(request.getSession().getAttribute(user.getUsername())!= null && user.getRole().equals("ADMIN")) {
            productService.saveOrUpdateProduct(product);
            return product.getId();
        }
        return -1;
    }
}
