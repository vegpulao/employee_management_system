package org.example.employee_management.controller;

import org.example.employee_management.dto.EmployeeRequest;
import org.example.employee_management.dto.EmployeeResponse;
import org.example.employee_management.dto.MessageResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.example.employee_management.service.Employeeservice;
import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/employees")
@RestController
public class Employeecontroller {
    private final Employeeservice service;

    public Employeecontroller(Employeeservice service) {

        this.service = service;
    }
    @GetMapping("/page")
    public Page<EmployeeResponse> getEmployees(
            @ParameterObject Pageable pageable) {

        return service.getEmployees(pageable);
    }
    @PostMapping
    public EmployeeResponse addEmployee(
            @Valid @RequestBody EmployeeRequest request) {

        return service.addEmployee(request);

    }
    @GetMapping
    public List<EmployeeResponse> getAllEmployees() {
        return service.getAllEmployees();
    }
    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Integer id) {
        return service.getEmployeeById(id);
    }
    @DeleteMapping("/{id}")
    public MessageResponse deleteEmployee(@PathVariable Integer id){
        return service.deleteEmployee(id);
    }
    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(
            @PathVariable Integer id,
            @Valid @RequestBody EmployeeRequest request) {

        return service.updateEmployee(id, request);
    }
    @GetMapping("/search/department/{department}")
    public List<EmployeeResponse> searchByDepartment(@PathVariable String department) {
        return service.searchByDepartment(department);
    }

    @GetMapping("/search/designation/{designation}")
    public List<EmployeeResponse> searchByDesignation(@PathVariable String designation) {
        return service.searchByDesignation(designation);
    }

    @GetMapping("/search/name/{name}")
    public List<EmployeeResponse> searchByName(@PathVariable String name) {
        return service.searchByName(name);
    }
}