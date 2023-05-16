package com.example.repositories;

import com.example.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpRepository {
    private List<Employee> list = new ArrayList<>();

    public void add(Employee emp) {
        list.add(emp);
    }

    public void remove(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==id){
                list.remove(i);
                return;
            }
        }
    }

    public Employee show(int id) {
        for (Employee emp : list) {
            if (id == emp.getId()) {
                return emp;
            }
        }
        throw new RuntimeException("employee with id " + id + " not found");
    }

    public void update(Employee employee) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == employee.getId()) {
                list.set(i, employee);
                return;
            }
        }
        throw new RuntimeException("employee: " + employee + " not found");
    }

    public List<Employee> getAll() {
        return list;
    }
}
