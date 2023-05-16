package com.example.controllers;


import com.example.models.Employee;
import com.example.repositories.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/emps")
public class EmployeesController {
    private final EmpRepository empRepository;

    @GetMapping()
    public List<Employee> getEmployees (){
        return empRepository.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById (@PathVariable int id){
        return empRepository.show(id);
    }

    @PostMapping()
    public List<Employee> create(@RequestBody Employee emp) {
        empRepository.add(emp);
        return empRepository.getAll();
    }

    @PatchMapping()
    public List<Employee> update(@RequestBody Employee emp) {
        empRepository.update(emp);
        return empRepository.getAll();
    }

    @DeleteMapping("/{id}")
    public List<Employee> delete(@PathVariable("id") int id) {
        empRepository.remove(id);
        return empRepository.getAll();
    }

}
