package com.example.petshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
@Table(name = "dogs")
public class Dog extends Pets {

    @Min(0)
    @Max(10)
    private int rating;

    public Dog() {
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


public BigDecimal calculateDogPrice(BigDecimal agePrice) {
    BigDecimal ratingPrice = new BigDecimal(rating);
    return agePrice.multiply(BigDecimal.ONE).add(ratingPrice.multiply(BigDecimal.ONE));
}
}
