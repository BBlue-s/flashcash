package com.example.flashcash.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.grammars.hql.HqlParser;

import java.time.LocalDateTime;


@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;



    private Double amountBeforeFee;
    private Double  amountAfterFee;



    private Integer fromId;
    private Integer toId;

}
