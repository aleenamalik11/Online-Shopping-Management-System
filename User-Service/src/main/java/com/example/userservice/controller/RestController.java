package com.example.userservice.controller;

import com.example.userservice.entity.Role;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user")
public class RestController {

    @Autowired
    UserService userService;
    private static Long u_id = new Long(4);

    @RequestMapping("/login")
    public boolean userLogin(@RequestBody User user)
    {
        String name = null;
        name = user.getUsername();
        User u = userService.getUserByName(name);
        if(u!=null && u.getPassword().equals(user.getPassword()) && u.getRole().getName().equals("USER")) {
            return true;
        }
        return false;
    }
    @RequestMapping("/adminLogin")
    public boolean adminLogin(@RequestBody User user)
    {
        String name = null;
        name = user.getUsername();
        User u = userService.getUserByName(name);
        if(u!=null && u.getPassword().equals(user.getPassword()) && u.getRole().getName().equals("ADMIN")) {
            return true;
        }
        return false;
    }

    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public User userSignup(@RequestBody User user)
    {
        Role role = new Role();
        role.setId(1);
        role.setName("USER");
        user.setId(++u_id);
        user.setEnabled(true);
        user.setRole(role);
        userService.saveOrUpdate(user);
        return user;
    }
}
