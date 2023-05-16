package com.example.models;

import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private int Id;
    private String name;
    private String surname;
    private String position;
    //должность
    private Employee boss;
    private List<Employee> subordinate;
    //подчиненные
    private List<Task> listOfTasks;
}
