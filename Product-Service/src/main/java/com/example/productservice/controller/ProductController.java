package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/all")
    private List<Product> getAllProducts()
    {
        return productService.findAllProducts();
    }
    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/{id}")
    private Product getProduct(@PathVariable("id") int id)
    {
        return productService.findProductById(id);
    }
    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/{id}")
    private void deleteStudent(@PathVariable("id") int id)
    {
        productService.deleteProduct(id);
    }
    //creating post mapping that post the student detail in the database
    @PostMapping("/student")
    private int saveStudent(@RequestBody Product product)
    {
        productService.saveOrUpdateProduct(product);
        return product.getId();
    }
}
