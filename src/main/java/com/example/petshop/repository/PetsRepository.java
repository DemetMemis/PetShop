package com.example.petshop.repository;

import com.example.petshop.model.Dog;
import com.example.petshop.model.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends JpaRepository<Pets,Long> {
}
