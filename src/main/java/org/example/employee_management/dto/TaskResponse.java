package org.example.employee_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {

    private Integer id;

    private String title;
    private String description;
    private String priority;
    private String status;
    private LocalDate dueDate;

    private Integer employeeId;
    private String employeeName;

}
