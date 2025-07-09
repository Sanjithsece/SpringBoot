package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    RegisterDetailsRepositary registerDetailsRepositary;
    @Autowired
    PasswordEncoder passwordEncoder;

    public String addNewEmployee(RegisterDetails register) {
      RegisterDetails registerDetails = new RegisterDetails();
      registerDetails.setEmpID(register.getEmpID());
      registerDetails.setEmpname(register.getEmpname());
      registerDetails.setEmail(register.getEmail());
        System.out.println( "password : " +register.getPassword()+" encode password " + passwordEncoder.encode(register.getPassword()));
      registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
      registerDetails.setGender(register.getGender());
      registerDetails.setDob(register.getDob());
      registerDetails.setRole(register.getRole());
      registerDetailsRepositary.save(registerDetails);
      return "Employee Added Successfully";
    }

    public String authenticate(RegisterDetails login) {
        RegisterDetails user = registerDetailsRepositary.findByEmail(login.getEmail());
        if (user == null) {
            return "User not found";
        }
        if (!passwordEncoder.matches(login.getPassword(), user.getPassword())) {
            return "Wrong Password ";
        }
        return "Login successful username : " + user.getEmpname();
    }
    public List<RegisterDetails> getAllUsers() {
        return registerDetailsRepositary.findAll();
    }
}
