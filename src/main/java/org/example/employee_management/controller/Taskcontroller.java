package org.example.employee_management.controller;

import org.example.employee_management.dto.MessageResponse;
import org.example.employee_management.dto.TaskRequest;
import org.example.employee_management.dto.TaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.example.employee_management.service.Taskservice;
import java.util.List;

@RequestMapping("/tasks")
@RestController
public class Taskcontroller {
    private final Taskservice service;

    public Taskcontroller(Taskservice service) {

        this.service = service;
    }
    @PostMapping
    public TaskResponse addTask(
            @RequestBody TaskRequest request) {

        return service.addTask(request);

    }
    @GetMapping("/{id}")
    public TaskResponse getTaskById(
            @PathVariable Integer id) {

        return service.getTaskById(id);

    }
    @DeleteMapping("/{id}")
    public MessageResponse deleteTask(
            @PathVariable Integer id) {

        return service.deleteTask(id);

    }
    @PutMapping("/{id}")
    public TaskResponse updateTask(
            @PathVariable Integer id,
            @RequestBody TaskRequest request) {

        return service.updateTask(id, request);

    }
    @GetMapping("/search/status/{status}")
    public List<TaskResponse> searchByStatus(@PathVariable String status) {
        return service.searchByStatus(status);
    }

    @GetMapping("/search/priority/{priority}")
    public List<TaskResponse> searchByPriority(@PathVariable String priority) {
        return service.searchByPriority(priority);
    }

    @GetMapping("/search/title/{title}")
    public List<TaskResponse> searchByTitle(@PathVariable String title) {
        return service.searchByTitle(title);
    }
    @GetMapping
    public Page<TaskResponse> getAllTasks(Pageable pageable) {

        return service.getAllTasks(pageable);

    }
    @GetMapping("/employee/{employeeId}")
    public Page<TaskResponse> getTasksByEmployee(
            @PathVariable Integer employeeId,
            Pageable pageable) {

        return service.getTasksByEmployee(employeeId, pageable);

    }
}