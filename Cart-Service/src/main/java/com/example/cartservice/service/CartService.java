package com.example.cartservice.service;

import com.example.cartservice.entity.Cart;
import com.example.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    void saveCart(Cart cart){
        cartRepository.save(cart);
    }

    void deleteCart(int id){
        cartRepository.deleteById(id);
    }

}
