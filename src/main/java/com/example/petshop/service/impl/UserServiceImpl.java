package com.example.petshop.service.impl;

import com.example.petshop.model.User;
import com.example.petshop.model.exceptions.UserNotFoundException;
import com.example.petshop.repository.PetsRepository;
import com.example.petshop.repository.UserRepository;
import com.example.petshop.service.UserService;
import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
 private UserRepository userRepository;
    @Autowired
 private PetsRepository petsRepository;

    public UserServiceImpl(UserRepository userRepository, PetsRepository petsRepository) {
        this.userRepository = userRepository;
        this.petsRepository = petsRepository;
    }


    @Override
    public List<User> ListUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User save(User user) {
        return null;
    }


@Override
public void createUsers() {
    Faker faker = new Faker();
    List<User> users = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        User user = new User();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setBudget(new BigDecimal(faker.number().numberBetween(1000,10000)));
        users.add(user);
    }
    userRepository.saveAll(users);
}
}



