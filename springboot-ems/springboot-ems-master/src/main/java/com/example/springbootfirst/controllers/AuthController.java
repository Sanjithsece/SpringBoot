package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/all")
    public List<RegisterDetails> getAllUsers() {
        return authService.getAllUsers();
    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody RegisterDetails register){
        return authService.addNewEmployee(register);
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterDetails loginDetails) {
        return authService.authenticate(loginDetails);
    }

}
