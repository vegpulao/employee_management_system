package org.example.employee_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private Double salary;

    @Column(unique = true)
    private String email;

    private String designation;
    private String department;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private List<Task> tasks;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private List<Leave_reqs> leaves;
}