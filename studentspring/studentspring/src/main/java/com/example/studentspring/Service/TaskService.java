package com.example.studentspring.Service;

import com.example.studentspring.Models.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TaskModel> getAllTasks() {
        String sql = "SELECT * FROM task_model";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TaskModel.class));
    }

    public int createTask(TaskModel task) {
        String sql = "INSERT INTO task_model (title, description, status) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, task.getTitle(), task.getDescription(), task.getStatus());
    }

    public int updateTask(Long id, TaskModel task) {
        String sql = "UPDATE task_model SET title = ?, description = ?, status = ? WHERE id = ?";
        return jdbcTemplate.update(sql, task.getTitle(), task.getDescription(), task.getStatus(), id);
    }

    public int deleteTask(Long id) {
        String sql = "DELETE FROM task_model WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateStatus(Long id, String status) {
        String sql = "UPDATE task_model SET status = ? WHERE id = ?";
        return jdbcTemplate.update(sql, status, id);
    }
}
