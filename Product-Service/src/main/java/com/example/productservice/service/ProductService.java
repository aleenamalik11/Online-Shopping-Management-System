package com.example.productservice.service;

import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    
    public void saveOrUpdateProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> findAllProducts(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    public Product findProductById(Integer id){
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

}

