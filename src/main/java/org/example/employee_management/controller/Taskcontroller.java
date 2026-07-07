package org.example.employee_management.controller;

import org.example.employee_management.entity.Employee;
import org.example.employee_management.entity.Task;
import org.springframework.web.bind.annotation.*;
import org.example.employee_management.service.Taskservice;
import java.util.Optional;
import java.util.List;

@RequestMapping("/tasks")
@RestController
public class Taskcontroller {
    private final Taskservice service;

    public Taskcontroller(Taskservice service) {

        this.service = service;
    }
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }
    @GetMapping
    public List<Task> getAllTask() {
        return service.getAllTask();
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Integer id) {
        return service.getTaskById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Integer id,
                                   @RequestBody Task task) {

        return service.updateTask(id, task);
    }
    @GetMapping("/search/status/{status}")
    public List<Task> searchByStatus(@PathVariable String status) {
        return service.searchByStatus(status);
    }

    @GetMapping("/search/priority/{priority}")
    public List<Task> searchByPriority(@PathVariable String priority) {
        return service.searchByPriority(priority);
    }

    @GetMapping("/search/title/{title}")
    public List<Task> searchByTitle(@PathVariable String title) {
        return service.searchByTitle(title);
    }
}