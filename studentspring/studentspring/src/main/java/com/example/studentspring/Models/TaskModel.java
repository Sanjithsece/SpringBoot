package com.example.studentspring.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {
    private Long id;
    private String title;
    private String description;
    private String status;
}
