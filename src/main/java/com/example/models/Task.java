package com.example.models;

import lombok.Data;

import java.time.Instant;

@Data
public class Task {
    private int id;
    private String name;
    private Instant dateOfAppointing;
    private Instant dateOfFinishing;
    private double timeOfExecution;
    //время выполнения, накопительно

}
