package com.example.demo.services;

import com.example.demo.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private List<Student> studentList = new ArrayList<>(List.of(
            new Student(1, "Arjun", "10A", 88),
            new Student(2, "Priya", "9B", 93)
    ));

    public List<Student> getAllStudents() {
        return studentList;
    }

    public String addStudent(Student student) {
        studentList.add(student);
        return "Student added: " + student.getName();
    }

    public String deleteStudentById(int rollNo) {
        Optional<Student> studentToDelete = studentList.stream()
                .filter(s -> s.getRollNo() == rollNo)
                .findFirst();

        if (studentToDelete.isPresent()) {
            studentList.remove(studentToDelete.get());
            return "Student with Roll No " + rollNo + " deleted.";
        } else {
            return "Student not found.";
        }
    }

    public String updateStudent(int rollNo, Student updatedStudent) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getRollNo() == rollNo) {
                studentList.set(i, updatedStudent);
                return "Student updated successfully.";
            }
        }
        return "Student not found.";
    }
}
