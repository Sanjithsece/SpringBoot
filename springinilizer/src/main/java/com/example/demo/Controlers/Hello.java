package com.example.demo.Controlers;

import com.example.demo.models.Course;
import com.example.demo.Services.helloservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class Hello {

    @Autowired
    private helloservices hws;

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return hws.getAllCourses();
    }


    @PostMapping("/add")
    public String addCourse(@RequestBody Course course) {
        return hws.addCourse(course);
    }

    @PutMapping("/{id}")
    public String putCourse(@PathVariable int id, @RequestBody Course course) {
        return hws.putCourse(id, course.getCourseName(), course.getDuration());
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        return hws.deleteCourseById(id);
    }
}


//    @PostMapping("/in")
//    public String sanjith(@RequestBody RequestName request) {
//        System.out.println("hi " + request.getName());
//        return "Received: " + request.getName();
//    }

//@PostMapping("/in")
//public String sanjith(@RequestBody  String request) {
//    System.out.println("hi " + request);
//    return "Received: " + request;
//}
//}


//class RequestName {
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
