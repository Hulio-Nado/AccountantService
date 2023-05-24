package com.example.controllers;

import com.example.models.Employee;
import com.example.repositories.EmpRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class EmployeesControllerTests {
    Employee emp;

    @BeforeEach
    void init() {
        emp = new Employee();
        emp.setName("name1");
        emp.setSurname("surname1");
        emp.setPosition("dev");
        emp.setId(1);
    }

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    EmpRepository empRepository;


    @Test
    public void shouldReturnEmployeeById() throws Exception {
        int id = 2;
        String expected = objectMapper.writeValueAsString(emp);
        when(empRepository.show(id)).thenReturn(emp);
        mockMvc.perform(get("/emps/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    public void getAllShouldReturnAllEmployee() throws Exception {
        List<Employee> emps = List.of(emp, emp);
        String expected = objectMapper.writeValueAsString(emps);

        when(empRepository.getAll()).thenReturn(emps);

        mockMvc.perform(get("/emps"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    public void createShouldInvokedAndReturnAllEmployee() throws Exception {
        List<Employee> emps = List.of(emp);
        String expected = objectMapper.writeValueAsString(emps);
        String content = objectMapper.writeValueAsString(emp);

        when(empRepository.getAll()).thenReturn(emps);

        mockMvc.perform(post("/emps").contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));

    }

    @Test
    public void updateShouldInvokedAndReturnAllEmployee() throws Exception {
        List<Employee> emps = List.of(emp);
        String expected = objectMapper.writeValueAsString(emps);
        String content = objectMapper.writeValueAsString(emp);
        when(empRepository.getAll()).thenReturn(emps);
        mockMvc.perform(post("/emps").contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    public void udeleteShouldInvokedAndReturnAllEmployee() throws Exception {
        int id = 2;
        List<Employee> emps = List.of(emp);
        String expected = objectMapper.writeValueAsString(emps);
        String content = objectMapper.writeValueAsString(emp);
        when(empRepository.getAll()).thenReturn(emps);
        mockMvc.perform(delete("/emps/{id}", id)
                .contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }
}
