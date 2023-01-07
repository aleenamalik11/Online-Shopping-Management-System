package com.example.productservice.controller;

import com.example.productservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="USER-SERVICE")
public interface UserRestConsumer {

    @RequestMapping("/user/login")
    public boolean userLogin(@RequestBody User user);
    @RequestMapping("/user/signup")
    public void userSignUp(@RequestBody User user);

    @RequestMapping("/adminLogin")
    public boolean adminLogin(@RequestBody User user);

}
