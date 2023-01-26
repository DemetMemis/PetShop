package com.example.petshop.web;

import com.example.petshop.model.Pets;
import com.example.petshop.service.PetsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsControler {
    private final PetsService petsService;
    public PetsControler(PetsService petsService) {
        this.petsService = petsService;
    }

    @GetMapping
    public List<Pets> ListPets() {
        return this.petsService.ListPets();
    }


    @PostMapping("/create")
    public void createPets() {
        petsService.createPets();
    }


    @PostMapping("/buyPetsforallUsers")
    public void buyPetsForAllUsers() {
        petsService.buyPet();
    }
}
