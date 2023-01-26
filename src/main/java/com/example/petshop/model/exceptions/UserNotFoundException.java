package com.example.petshop.model.exceptions;

public class UserNotFoundException extends RuntimeException{
public UserNotFoundException (){
    super("User Not Found");
}
}
