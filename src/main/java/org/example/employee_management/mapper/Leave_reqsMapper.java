package org.example.employee_management.mapper;

import org.example.employee_management.dto.Leave_reqsResponse;
import org.example.employee_management.entity.Leave_reqs;

public class Leave_reqsMapper {

    private Leave_reqsMapper() {
    }

    public static Leave_reqsResponse toResponse(Leave_reqs leave) {

        return new Leave_reqsResponse(
                leave.getId(),
                leave.getReason(),
                leave.getStartDate(),
                leave.getEndDate(),
                leave.getStatus(),
                leave.getEmployee().getId(),
                leave.getEmployee().getName()
        );

    }

}
