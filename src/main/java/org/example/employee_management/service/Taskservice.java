package org.example.employee_management.service;

import org.example.employee_management.entity.Task;
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
    public Optional<Task> getTaskById(Integer id) {
        return repository.findById(id);
    }

    // Update task
    public Task updateTask(Task task) {
        return repository.save(task);
    }

    // Delete task
    public void deleteTask(Integer id) {
        repository.deleteById(id);
    }
}