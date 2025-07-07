package com.example.ToDoList.Controller;

import com.example.ToDoList.Model.ToDoModel;
import com.example.ToDoList.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/List")
public class ToDoController {

    @Autowired
    private TodoService hws;

    @GetMapping("/all")
    public List<ToDoModel> getAlltask() {
        return hws.getAlltask();
    }

    @GetMapping("/{id}")
    public ToDoModel getTaskByid(@PathVariable int id) {
        return hws.getTaskbyid(id);
    }

    @PostMapping("/add")
    public String addtask(@RequestBody ToDoModel tod) {
        return hws.addTask(tod);
    }

    @PutMapping("/update")
    public String updateTask(@RequestBody ToDoModel tod) {
        return hws.updateTask(tod);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        return hws.deletetask(id);
    }
}
