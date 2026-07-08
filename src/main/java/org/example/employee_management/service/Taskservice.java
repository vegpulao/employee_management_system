package org.example.employee_management.service;

import org.example.employee_management.dto.MessageResponse;
import org.example.employee_management.dto.TaskRequest;
import org.example.employee_management.dto.TaskResponse;
import org.example.employee_management.entity.Employee;
import org.example.employee_management.entity.Task;
import org.example.employee_management.exception.ResourceNotFoundException;
import org.example.employee_management.mapper.TaskMapper;
import org.example.employee_management.repository.Employeerepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.example.employee_management.repository.Taskrepository;
import java.util.List;

@Service
public class Taskservice {

    private final Taskrepository repository;
    private final Employeerepository employeeRepository;

    public Taskservice(Taskrepository repository,Employeerepository employeeRepository) {
        this.repository = repository;
        this.employeeRepository = employeeRepository;
    }

    // Add task
    public TaskResponse addTask(TaskRequest request) {

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setStatus(request.getStatus());
        task.setDueDate(request.getDueDate());
        task.setEmployee(employee);

        task = repository.save(task);

        return TaskMapper.toResponse(task);
    }

    // Search task by ID
    public TaskResponse getTaskById(Integer id) {

        Task task = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        return TaskMapper.toResponse(task);
    }

    // Update task
    public TaskResponse updateTask(
            Integer id,
            TaskRequest request) {

        Task task = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setStatus(request.getStatus());
        task.setDueDate(request.getDueDate());
        task.setEmployee(employee);

        task = repository.save(task);

        return TaskMapper.toResponse(task);
    }

    // Delete task
    public MessageResponse deleteTask(Integer id) {

        repository.deleteById(id);

        return new MessageResponse("Task deleted successfully.");

    }

    // Search services
    public List<TaskResponse> searchByStatus(String status) {

        return repository.findByStatus(status)
                .stream()
                .map(TaskMapper::toResponse)
                .toList();

    }

    public List<TaskResponse> searchByPriority(String priority) {

        return repository.findByPriority(priority)
                .stream()
                .map(TaskMapper::toResponse)
                .toList();

    }

    public List<TaskResponse> searchByTitle(String title) {

        return repository.findByTitleContaining(title)
                .stream()
                .map(TaskMapper::toResponse)
                .toList();

    }

    // Pagination
    // View all tasks
    public Page<TaskResponse> getAllTasks(Pageable pageable) {

        return repository.findAll(pageable)
                .map(TaskMapper::toResponse);

    }

    // View tasks by employee id
    public Page<TaskResponse> getTasksByEmployee(
            Integer employeeId,
            Pageable pageable) {

        return repository.findByEmployeeId(employeeId, pageable)
                .map(TaskMapper::toResponse);

    }
}