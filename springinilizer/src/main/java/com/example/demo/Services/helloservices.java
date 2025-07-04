package com.example.demo.Services;

import com.example.demo.models.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
        for (Course c : courseList) {
            if (c.getCourseName().equals(course.getCourseName())) {
                return "Course already exists: " + course.getCourseName();
            }
        }
        courseList.add(course);
        return "Course added: " + course.getCourseName();
    }
    public String putCourse(int id, String newCourseName, String duration) {
        for (Course course : courseList) {
            if (course.getCourseId() == id) {
                course.setCourseName(newCourseName);
                course.setDuration(duration);
                return "Course updated: " + course.getCourseName();
            }
        }
        return "Course not found with ID: " + id;
    }
    public String deleteCourseById(int id) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseId() == id) {
                courseList.remove(i);
                return id + " deleted successfully.";
            }
        }
        return id + " not found.";
    }
}
