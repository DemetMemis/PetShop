package com.example.petshop.service.impl;

import com.example.petshop.model.*;
import com.example.petshop.model.exceptions.PetNotFoundException;
import com.example.petshop.model.exceptions.UserNotFoundException;
import com.example.petshop.repository.HistoryLogRepository;
import com.example.petshop.repository.PetsRepository;
import com.example.petshop.repository.UserRepository;
import com.example.petshop.service.PetsService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class PetsServiceImpl implements PetsService {

@Autowired
    private PetsRepository petsRepository;
@Autowired
    private UserRepository userRepository;
@Autowired
 private HistoryLogRepository historyLogRepository;

    public PetsServiceImpl(PetsRepository petsRepository, UserRepository userRepository) {
        this.petsRepository = petsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Pets> ListPets() {
        return this.petsRepository.findAll();
    }

    @Override
    public Pets findById(Long id) {
        return petsRepository.findById(id).orElseThrow(PetNotFoundException::new);
    }



    @Override
    public void buyPet() {
        List<User> users = userRepository.findAll();
        List<Pets> pets = petsRepository.findAll();
        int successfulBuyers = 0;
        int unsuccessfulBuyers = 0;
        for (User user : users) {
            Pets pet = selectRandomPet(pets);
            if (user.getBudget().compareTo(pet.getPrice()) > 0 && pet.isAdopted()==false ) {
                userRepository.save(user);
                pet.setOwner(user);
                pet.setAdopted(true);
                petsRepository.save(pet);
                if (pet.getType().equals(PetType.CAT))
                    System.out.println("Meow, cat " + pet.getName() + " has owner " + user.getFirstName());

                else System.out.println("Howw, dog " + pet.getName() + " has owner " + user.getFirstName());
                successfulBuyers++;
            }

            else{
                    unsuccessfulBuyers++;
                }
            } HistoryLog log = new HistoryLog();
        log.setDateOfExecution(LocalDateTime.now());
        log.setSuccessfulBuyers(successfulBuyers);
        log.setUnsuccessfulBuyers(unsuccessfulBuyers);
        historyLogRepository.save(log);

        }






    @Override
    public void createPets(){
        Faker faker = new Faker();
        List<Pets> pets = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Pets pet = new Pets();
            pet.setName(faker.name().firstName());
            pet.setDescription(faker.lorem().sentence());
            Date date = faker.date().birthday();
            LocalDate birthday = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            pet.setDateOfBirth(birthday);
            pet.setPrice(new BigDecimal(faker.number().randomDouble(2, 0, 100)));
            int randomType = faker.number().numberBetween(0,1);
            if(randomType == 1){
                pet.setType(PetType.CAT);
                pet.calculatePrice();

            }else{
                pet.setType(PetType.DOG);
                Dog dog = new Dog();
                dog.setRating(faker.number().numberBetween(0, 10));
                dog.setType(PetType.DOG);
                dog.setName(pet.getName());
                dog.setDescription(pet.getDescription());
                dog.setDateOfBirth(pet.getDateOfBirth());
                dog.calculatePrice();
                pet = dog;
            }

            pets.add(pet);
        }
        petsRepository.saveAll(pets);
    }

    @Override
    public Pets selectRandomPet(List<Pets> pets) {
        Random rand = new Random();
        int  n = rand.nextInt(pets.size());
        return pets.get(n);
    }
}
