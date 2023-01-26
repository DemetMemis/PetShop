package com.example.petshop.model.exceptions;

public class PetNotFoundException extends RuntimeException{
    public PetNotFoundException(){
        super("PetNotFound");
    }
}
