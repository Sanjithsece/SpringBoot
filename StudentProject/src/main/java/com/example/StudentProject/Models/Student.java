package com.example.StudentProject.Models;

public class Student {
    private int rollNo;
    private String name;
    private String studentClass;
    private int mark;

    public Student() {}

    public Student(int rollNo, String name, String studentClass, int mark) {
        this.rollNo = rollNo;
        this.name = name;
        this.studentClass = studentClass;
        this.mark = mark;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
