package com.example.StudentProject.Controller;

import com.example.StudentProject.Models.Student;
import com.example.StudentProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{rollNo}")
    public String deleteStudent(@PathVariable int rollNo) {
        return studentService.deleteStudentById(rollNo);
    }

    @PutMapping("/{rollNo}")
    public String updateStudent(@PathVariable int rollNo, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(rollNo, updatedStudent);
    }
}
