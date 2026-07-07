package org.example.employee_management.service;

import org.example.employee_management.dto.EmployeeRequest;
import org.example.employee_management.dto.EmployeeResponse;
import org.example.employee_management.dto.MessageResponse;
import org.example.employee_management.entity.Employee;
import org.example.employee_management.mapper.EmployeeMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public EmployeeResponse addEmployee(EmployeeRequest request) {

        Employee employee = EmployeeMapper.toEntity(request);

        employee = repository.save(employee);

        return EmployeeMapper.toResponse(employee);

    }

    // View All employees
    public List<EmployeeResponse> getAllEmployees() {

        return repository.findAll()
                .stream()
                .map(EmployeeMapper::toResponse)
                .toList();

    }

    // Search employee by ID
    public EmployeeResponse getEmployeeById(Integer id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->

                        new ResourceNotFoundException("Employee with id " + id + " not found"));;

        return EmployeeMapper.toResponse(employee);

    }

    // Update employee
    public EmployeeResponse updateEmployee(
            Integer id,
            EmployeeRequest request) {

        Employee existing = repository.findById(id)
                .orElseThrow(() ->

                        new ResourceNotFoundException("Employee with id " + id + " not found"));

        existing.setName(request.getName());
        existing.setAge(request.getAge());
        existing.setSalary(request.getSalary());
        existing.setEmail(request.getEmail());
        existing.setDesignation(request.getDesignation());
        existing.setDepartment(request.getDepartment());

        existing = repository.save(existing);

        return EmployeeMapper.toResponse(existing);

    }

    // Delete employee
    public MessageResponse deleteEmployee(Integer id) {

        repository.deleteById(id);

        return new MessageResponse(
                "Employee deleted successfully."
        );

    }

    // Search services
    public List<EmployeeResponse> searchByDepartment(String department) {

        return repository.findByDepartment(department)
                .stream()
                .map(EmployeeMapper::toResponse)
                .toList();

    }

    public List<EmployeeResponse> searchByDesignation(String designation) {

        return repository.findByDesignation(designation)
                .stream()
                .map(EmployeeMapper::toResponse)
                .toList();

    }

    public List<EmployeeResponse> searchByName(String name) {

        return repository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(EmployeeMapper::toResponse)
                .toList();

    }

    // Pagination
    public Page<EmployeeResponse> getEmployees(Pageable pageable) {

        return repository.findAll(pageable)
                .map(EmployeeMapper::toResponse);

    }
}

