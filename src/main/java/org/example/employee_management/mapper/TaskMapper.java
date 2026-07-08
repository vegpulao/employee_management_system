package org.example.employee_management.mapper;

import org.example.employee_management.dto.TaskResponse;
import org.example.employee_management.entity.Task;

public class TaskMapper {

    private TaskMapper() {
    }

    public static TaskResponse toResponse(Task task) {

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getStatus(),
                task.getDueDate(),
                task.getEmployee().getId(),
                task.getEmployee().getName()
        );
    }

}
