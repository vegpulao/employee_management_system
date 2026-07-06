package service;

import entity.Employee;
import org.springframework.stereotype.Service;
import repository.Employeerepository;
import java.util.List;
import java.util.Optional;

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
    public Optional<Employee> getEmployeeById(Integer id) {
        return repository.findById(id);
    }

    // Update employee
    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Delete employee
    public void deleteEmployee(Integer id) {
        repository.deleteById(id);
    }
}
