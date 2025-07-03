package com.example.demo.Services;

import com.example.demo.models.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class helloservices {

    private List<Course> courseList = new ArrayList<>(List.of(
            new Course(1, "dsa", "2.5h"),
            new Course(2, "spring", "4.3h")
    ));

    public List<Course> getAllCourses() {
        return courseList;
    }

    public String addCourse(Course course) {
        courseList.add(course);
        return "Course added: " + course.getCourseName();
    }

    public String deleteCourseById(int id) {
        Optional<Course> courseToDelete = courseList.stream()
                .filter(course -> course.getCourseId() == id)
                .findFirst();

        if (courseToDelete.isPresent()) {
            courseList.remove(courseToDelete.get());
            return "Course with ID " + id + " deleted successfully.";
        } else {
            return "Course with ID " + id + " not found.";
        }
    }
}
