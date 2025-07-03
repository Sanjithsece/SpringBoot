package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET: All students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // POST: Add a new student
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // DELETE: Remove a student by roll number
    @DeleteMapping("/{rollNo}")
    public String deleteStudent(@PathVariable int rollNo) {
        return studentService.deleteStudentById(rollNo);
    }

    // PUT: Update student info by roll number
    @PutMapping("/{rollNo}")
    public String updateStudent(@PathVariable int rollNo, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(rollNo, updatedStudent);
    }
}
