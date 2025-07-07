package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Courses_model")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;

    @Column(name = "course_name", nullable = false)
    private String course_name;

    @Column(name = "duration", nullable = false)
    private String duration;

    public Course() {
    }

    public Course(Integer course_id, String course_name, String duration) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.duration = duration;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
