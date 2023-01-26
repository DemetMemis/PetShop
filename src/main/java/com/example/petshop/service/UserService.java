package com.example.petshop.service;

import com.example.petshop.model.Pets;
import com.example.petshop.model.User;

import java.util.List;

public interface UserService {
    List<User> ListUsers();
    User findById(Long id);
    User save(User user);
    void createUsers();
}
