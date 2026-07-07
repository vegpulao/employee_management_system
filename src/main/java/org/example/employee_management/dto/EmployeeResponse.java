package org.example.employee_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private Integer id;
    private String name;
    private Integer age;
    private Double salary;
    private String email;
    private String designation;
    private String department;

}
