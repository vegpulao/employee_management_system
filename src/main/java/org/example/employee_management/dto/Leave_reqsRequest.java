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
public class Leave_reqsRequest {

    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    private Integer employeeId;

}
