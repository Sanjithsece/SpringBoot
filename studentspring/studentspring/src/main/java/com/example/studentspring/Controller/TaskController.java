package com.example.studentspring.Controller;

import com.example.studentspring.Models.TaskModel;
import com.example.studentspring.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Get all tasks
    @GetMapping
    public List<TaskModel> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Add a new task
    @PostMapping
    public String addTask(@RequestBody TaskModel task) {
        if (taskService.createTask(task) > 0) {
            return "Task added!";
        } else {
            return "Failed to add task.";
        }
    }

    // Edit task by id
    @PutMapping("/{id}")
    public String editTask(@PathVariable Long id, @RequestBody TaskModel task) {
        if (taskService.updateTask(id, task) > 0) {
            return "Task updated!";
        } else {
            return "Task not found.";
        }
    }

    // Update task status
    @PatchMapping("/{id}/status")
    public String changeTaskStatus(@PathVariable Long id, @RequestParam String status) {
        if (taskService.updateStatus(id, status) > 0) {
            return "Status updated!";
        } else {
            return "Task not found.";
        }
    }

    // Delete task by id
    @DeleteMapping("/{id}")
    public String removeTask(@PathVariable Long id) {
        if (taskService.deleteTask(id) > 0) {
            return "Task deleted!";
        } else {
            return "Task not found.";
        }
    }
}
