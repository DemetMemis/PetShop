package com.example.petshop.service;

import com.example.petshop.model.Pets;
import com.example.petshop.model.User;

import java.util.List;

public interface PetsService {
    List<Pets> ListPets();
    Pets findById(Long id);
    void buyPet();
    void createPets();
    Pets selectRandomPet(List<Pets> pets);
}
