package com.example.springbootfirst.controllers;


import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {

    @Autowired
    private HelloWorldService hws;

    @GetMapping
    public List<Employee> getMethod(){
        return hws.getMethod();
    }

    @GetMapping("/{empID}")
    public Employee getEmployeeById(@PathVariable int empID){
        return hws.getEmployeeById(empID);
    }

    @PostMapping("/add")
    public String postMethod(@RequestBody Employee employee){
        return hws.addEmployee(employee);
    }

    @PutMapping("/update")
    public String putMethod(@RequestBody Employee employee){
        return hws.updateEmployee(employee);
    }

    @DeleteMapping("/{empID}")
    public String deleteMethod(@PathVariable int empID){
        return hws.deleteEmployeeById(empID);
    }
}
