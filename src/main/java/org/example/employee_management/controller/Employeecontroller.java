package org.example.employee_management.controller;

import org.example.employee_management.entity.Employee;
import org.springframework.web.bind.annotation.*;
import org.example.employee_management.service.Employeeservice;
import java.util.List;

@RequestMapping("/employees")
@RestController
public class Employeecontroller {
    private final Employeeservice service;

    public Employeecontroller(Employeeservice service) {

        this.service = service;
    }
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {

        return service.addEmployee(employee);
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return service.getEmployeeById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id,
                                   @RequestBody Employee employee) {

        return service.updateEmployee(id, employee);
    }
    @GetMapping("/search/department/{department}")
    public List<Employee> searchByDepartment(@PathVariable String department) {
        return service.searchByDepartment(department);
    }

    @GetMapping("/search/designation/{designation}")
    public List<Employee> searchByDesignation(@PathVariable String designation) {
        return service.searchByDesignation(designation);
    }

    @GetMapping("/search/name/{name}")
    public List<Employee> searchByName(@PathVariable String name) {
        return service.searchByName(name);
    }
}