package com.example.flashcash.model;
import jakarta.persistence.*;
import org.hibernate.grammars.hql.HqlParser;
import java.time.LocalDateTime;

@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    @ManyToOne
    private User form;
    @ManyToOne
    private User to;
    private Double amountBeforeFee;
    private Double  amountAfterFee;

}
