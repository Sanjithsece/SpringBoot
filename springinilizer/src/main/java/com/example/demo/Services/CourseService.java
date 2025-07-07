package com.example.demo.services;

import com.example.demo.models.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public String addCourse(Course course) {
        courseRepository.save(course);
        return "Course added successfully!";
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer id) {
        Optional<Course> opt = courseRepository.findById(id);
        return opt.orElse(null);
    }

    public String updateCourse(Course course) {
        if (course.getCourse_id() != null && courseRepository.existsById(course.getCourse_id())) {
            courseRepository.save(course);
            return "Course updated successfully!";
        }
        return "Course not found.";
    }

    public String deleteCourseById(Integer id) {
        if (!courseRepository.existsById(id)) {
            return "Course not found.";
        }
        courseRepository.deleteById(id);
        return "Course deleted successfully!";
    }
}
