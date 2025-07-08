package com.example.StudentProject.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AuthenticationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authID;

    private String name;
    private String password;
    private String email;
    private String gender;

    // Default constructor
    public AuthenticationModel() {}

    public AuthenticationModel(int authID, String name, String password, String email, String gender) {
        this.authID = authID;
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
    }

    public int getAuthID() {
        return authID;
    }

    public void setAuthID(int authID) {
        this.authID = authID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
