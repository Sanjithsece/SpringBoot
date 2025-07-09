package com.example.springbootfirst.controllers;


import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private HelloWorldService hws;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String route(){
        return "Employee Management ";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/employee")
    public List<Employee> getMethod(){
        return hws.getMethod();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/employee/{empID}")
    public Employee getEmployeeById(@PathVariable int empID){
        return hws.getEmployeeById(empID);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee/add")
    public String postMethod(@RequestBody Employee employee){
        return hws.addEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee/update")
    public String putMethod(@RequestBody Employee employee){
        return hws.updateEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employee/{empID}")
    public String deleteMethod(@PathVariable int empID){
        return hws.deleteEmployeeById(empID);
    }
}
