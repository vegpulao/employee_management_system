package org.example.employee_management.mapper;

import org.example.employee_management.dto.EmployeeRequest;
import org.example.employee_management.dto.EmployeeResponse;
import org.example.employee_management.entity.Employee;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeRequest request) {

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setAge(request.getAge());
        employee.setSalary(request.getSalary());
        employee.setEmail(request.getEmail());
        employee.setDesignation(request.getDesignation());
        employee.setDepartment(request.getDepartment());

        return employee;
    }

    public static EmployeeResponse toResponse(Employee employee) {

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getSalary(),
                employee.getEmail(),
                employee.getDesignation(),
                employee.getDepartment()
        );
    }
}
