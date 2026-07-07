package org.example.employee_management.repository;

import org.example.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Employeerepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByDepartment(String department);

    List<Employee> findByDesignation(String designation);

    List<Employee> findByNameContainingIgnoreCase(String name);

}