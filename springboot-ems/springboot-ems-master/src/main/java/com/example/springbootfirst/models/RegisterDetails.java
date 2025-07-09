package com.example.springbootfirst.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empID;

    @Column(name = "emp_name")
    private String empname;
    private String email;
    private String password;
    private String gender;

    @Column(name = "date_of_birth")
    private LocalDate dob;
    private String role;
}