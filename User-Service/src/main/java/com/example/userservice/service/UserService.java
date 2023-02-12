package com.example.userservice.service;

import java.util.ArrayList;
import java.util.List;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;
    //getting all User records
    public List<User> getAllUser()
    {
        List<User> Users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> Users.add(user));
        return Users;
    }
    //getting a specific record
    public User getUserById(Long id)
    {
        return userRepository.findById(id).get();
    }
    public User getUserByName(String username)
    {
        return userRepository.getUserByUsername(username);
    }
    public User saveOrUpdate(User User)
    {
        return userRepository.save(User);
    }
    //deleting a specific record
    public void delete(Long id)
    {
        userRepository.deleteById(id);
    }
}

