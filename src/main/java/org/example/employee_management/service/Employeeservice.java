package org.example.employee_management.service;

import org.example.employee_management.entity.Employee;
import org.example.employee_management.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.example.employee_management.repository.Employeerepository;
import java.util.List;

@Service
public class Employeeservice {

    private final Employeerepository repository;

    public Employeeservice(Employeerepository repository) {
        this.repository = repository;
    }

    // Add employee
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    // View All employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Search employee by ID
    public Employee getEmployeeById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + id + " not found"));
    }

    // Update employee
    public Employee updateEmployee(Integer id, Employee employee) {

        repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + id + " not found"));

        employee.setId(id);

        return repository.save(employee);
    }

    // Delete employee
    public void deleteEmployee(Integer id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + id + " not found"));

        repository.delete(employee);
    }
}
