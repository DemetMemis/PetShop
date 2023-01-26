package com.example.petshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class HistoryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateOfExecution;
    private int successfulBuyers;
    private int unsuccessfulBuyers;


    public LocalDateTime getDateOfExecution() {
        return dateOfExecution;
    }

    public int getSuccessfulBuyers() {
        return successfulBuyers;
    }

    public int getUnsuccessfulBuyers() {
        return unsuccessfulBuyers;
    }

    public void setDateOfExecution(LocalDateTime dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    public void setSuccessfulBuyers(int successfulBuyers) {
        this.successfulBuyers = successfulBuyers;
    }

    public void setUnsuccessfulBuyers(int unsuccessfulBuyers) {
        this.unsuccessfulBuyers = unsuccessfulBuyers;
    }

}
