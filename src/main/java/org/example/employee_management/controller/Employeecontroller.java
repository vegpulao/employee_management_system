package org.example.employee_management.controller;

import org.example.employee_management.entity.Employee;
import org.springframework.web.bind.annotation.*;
import org.example.employee_management.service.Employeeservice;
import java.util.Optional;
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
    public Optional<Employee> getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id,
                                  @RequestBody Employee employee) {

        employee.setId(id);

        return service.updateEmployee(employee);
    }
}