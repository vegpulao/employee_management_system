package org.example.employee_management.repository;

import org.example.employee_management.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Taskrepository extends JpaRepository<Task, Integer> {
    List<Task> findByStatus(String status);

    List<Task> findByPriority(String priority);

    List<Task> findByTitleContaining(String title);

    Page<Task> findByEmployeeId(Integer employeeId, Pageable pageable);
}
