package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

public class Course {

    private int course_id;
    private String course_name;
    @Getter
    @Setter
    private String duration;

    public Course(int course_id, String course_name, String duration) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.duration = duration;
    }

    public int getCourseId() {
        return course_id;
    }

    public String getCourseName() {
        return course_name;
    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;
    }

    public void setCourseName(String course_name) {
        this.course_name = course_name;
    }
    public void setCourseDuration(String duration){
        this.duration = duration;
    }

}
