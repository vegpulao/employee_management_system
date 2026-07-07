package org.example.employee_management.service;

import org.example.employee_management.entity.Employee;
import org.example.employee_management.entity.Task;
import org.example.employee_management.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.example.employee_management.repository.Taskrepository;
import java.util.List;
import java.util.Optional;

@Service
public class Taskservice {

    private final Taskrepository repository;

    public Taskservice(Taskrepository repository) {
        this.repository = repository;
    }

    // Add task
    public Task addTask(Task task) {
        return repository.save(task);
    }

    // View All tasks
    public List<Task> getAllTask() {
        return repository.findAll();
    }

    // Search task by ID
    public Task getTaskById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task with id " + id + " not found"));
    }

    // Update task
    public Task updateTask(Integer id, Task task) {

        repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task with id " + id + " not found"));

        task.setId(id);

        return repository.save(task);
    }

    // Delete task
    public void deleteTask(Integer id) {
        Task task = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task with id " + id + " not found"));

        repository.delete(task);
    }

    // Search services
    public List<Task> searchByStatus(String status) {
        return repository.findByStatus(status);
    }

    public List<Task> searchByPriority(String priority) {
        return repository.findByPriority(priority);
    }

    public List<Task> searchByTitle(String title) {
        return repository.findByTitleContaining(title);
    }

    // Pagination
    public Page<Task> getTask(Pageable pageable) {
        return repository.findAll(pageable);
    }
}