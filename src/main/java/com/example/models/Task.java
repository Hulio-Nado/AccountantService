package com.example.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private String name;
    private Instant dateOfAppointing;
    private Instant dateOfFinishing;
    private double timeOfExecution;
    //время выполнения, накопительно

}
