package com.example.petshop;


import static org.junit.jupiter.api.Assertions.*;

import com.example.petshop.model.Dog;
import com.example.petshop.model.PetType;
import com.example.petshop.model.Pets;
import com.example.petshop.model.User;
import com.example.petshop.repository.PetsRepository;

import com.example.petshop.service.impl.PetsServiceImpl;

import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.math.BigDecimal;
import java.util.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class PetServiceTest {

    @Mock
    private PetsRepository petsRepository;

    @InjectMocks
    private PetsServiceImpl petService;

    private Pets pet1;
    private Pets pet2;
    private List<Pets> pets;

    @Before
    public void setUp() {
        pet1 = new Pets();
        pet1.setId(1L);
        pet1.setName("Name1");
        pet1.setDescription("cute");
        pet1.setType(PetType.CAT);
        pet1.setPrice(new BigDecimal(5000));


        pet2 = new Pets();
        pet2.setId(2L);
        pet2.setName("Name2");
        pet2.setDescription("cute2");
        pet2.setType(PetType.CAT);
        pet1.setPrice(new BigDecimal(5000));

        pets = Arrays.asList(pet1, pet2);
    }

    @Test
    public void testListUsers() {
        when(petsRepository.findAll()).thenReturn(pets);
        List<Pets> result = petService.ListPets();
        assertEquals(pets, result);
    }
}

