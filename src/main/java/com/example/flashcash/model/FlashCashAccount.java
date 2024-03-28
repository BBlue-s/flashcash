package com.example.flashcash.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class FlashCashAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double totalAmount;
    private Double flashCashAmount;

}
