package com.example.controllers;

import com.example.models.Employee;
import com.example.models.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @GetMapping()
    public List<Task> getTasks (){
        return null;
    }

    @GetMapping("/{id}")
    public Employee getTaskByID (@PathVariable int id){
        return null;
    }

    @GetMapping("/new")
    public String newTask(Task task) {
        return null;
    }

    @PostMapping()
    public String create(Task task) {
        return null;
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id) {
        return null;
    }

    @PatchMapping("/{id}")
    public String update(Task task, @PathVariable("id") int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        return null;
    }

}
