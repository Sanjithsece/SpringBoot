package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class Hello {

    @Autowired
    private CourseService service;

    @PostMapping("/add")
    public String addCourse(@RequestBody Course course) {
        return service.addCourse(course);
    }

    @GetMapping("/all")
    public List<Course> getAll() {
        return service.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Integer id) {
        return service.getCourseById(id);
    }

    @PutMapping("/update")
    public String updateCourse(@RequestBody Course course) {
        return service.updateCourse(course);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return service.deleteCourseById(id);
    }
}
