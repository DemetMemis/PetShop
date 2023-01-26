package com.example.petshop.model;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
public class Pets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "owner_id",nullable = true)
    private User owner;


    private String name;


    @Enumerated(EnumType.STRING)
    private PetType type;

    private String description;

    private LocalDate dateOfBirth;

    private BigDecimal price;

    private boolean isAdopted;



    public boolean isAdopted() {
        return isAdopted;
    }


    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }


    public Pets() {
    }


    public Pets(Long id, User owner, String name, PetType type, String description, LocalDate dateOfBirth, BigDecimal price, boolean isAdopted) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.type = type;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
        this.isAdopted = isAdopted;
    }

    public Pets(String name, PetType type, String description, LocalDate dateOfBirth, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
    }

    public void calculatePrice() {
        Period period = Period.between(dateOfBirth, LocalDate.now());
        int ageInYears = period.getYears();
        BigDecimal agePrice = new BigDecimal(ageInYears);
        if (this.type == PetType.CAT) {
            this.price = agePrice.multiply(BigDecimal.ONE);
        } else if (this.type == PetType.DOG) {
            if(this instanceof Dog){
                this.price = ((Dog) this).calculateDogPrice(agePrice);
            }
        }
    }


}
