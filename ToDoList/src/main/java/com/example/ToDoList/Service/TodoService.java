package com.example.ToDoList.Service;

import com.example.ToDoList.Model.ToDoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    List<ToDoModel> Data = new ArrayList<>();

    // Corrected constructor
    public TodoService() {
        Data.add(new ToDoModel(1, "sanjith", "ToDoList", "In Progress"));
        Data.add(new ToDoModel(2, "Prasanth", "Employee", "Started"));
    }

    public List<ToDoModel> getAlltask() {
        return Data;
    }

    public ToDoModel getTaskbyid(int id) {
        for (ToDoModel task : Data) {
            if (task.getId() == id) {
                return task;
            }
        }
        return new ToDoModel();
    }

    public String addTask(ToDoModel task) {
        task.setStatus("Yet to Start");
        Data.add(task);
        return "Task Added Successfully";
    }

    public String updateTask(ToDoModel updatedTask) {
        for (int i = 0; i < Data.size(); i++) {
            ToDoModel currentTask = Data.get(i);
            if (updatedTask.getId() == currentTask.getId()) {
                if (updatedTask.getName() != null) {
                    currentTask.setName(updatedTask.getName());
                }
                if (updatedTask.getTitle() != null) {
                    currentTask.setTitle(updatedTask.getTitle());
                }
                if (updatedTask.getStatus() != null) {
                    currentTask.setStatus(updatedTask.getStatus());
                }
                return "Task updated successfully";
            }
        }
        return "No such task existed";
    }

    public String deletetask(int id) {
        for (int i = 0; i < Data.size(); i++) {
            if (Data.get(i).getId() == id) {
                Data.remove(i);
                return "Task Deleted successfully";
            }
        }
        return "No Such Task Existed";
    }
}
