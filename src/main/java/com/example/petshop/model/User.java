package com.example.petshop.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;


    private String lastName;

    @Email

    private String email;

    private BigDecimal budget;

    public User() {
    }

    public User( String firstName,  String lastName, @Email  String email, BigDecimal budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.budget = budget;
    }
}
