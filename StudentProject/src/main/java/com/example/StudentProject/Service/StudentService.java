package com.example.StudentProject.Service;

import com.example.StudentProject.Models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> studentList = new ArrayList<>();

    public List<Student> getAllStudents() {
        return studentList;
    }

    public String addStudent(Student student) {
        studentList.add(student);
        return "Student added successfully!";
    }

    public String deleteStudentById(int rollNo) {
        boolean removed = studentList.removeIf(s -> s.getRollNo() == rollNo);
        return removed ? "Student deleted successfully!" : "Student not found!";
    }

    public String updateStudent(int rollNo, Student updatedStudent) {
        for (Student s : studentList) {
            if (s.getRollNo() == rollNo) {
                s.setName(updatedStudent.getName());
                s.setStudentClass(updatedStudent.getStudentClass());
                s.setMark(updatedStudent.getMark());
                return "Student updated successfully!";
            }
        }
        return "Student not found!";
    }
}
