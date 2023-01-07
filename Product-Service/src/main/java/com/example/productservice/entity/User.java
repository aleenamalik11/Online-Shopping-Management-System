package com.example.productservice.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String email;
    private String username;
    private String password;
    private boolean enabled;
    private Role role = new Role();
}

