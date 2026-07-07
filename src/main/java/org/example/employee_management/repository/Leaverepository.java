package org.example.employee_management.repository;

import org.example.employee_management.entity.Leave;
import org.example.employee_management.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Leaverepository extends JpaRepository<Leave,Integer> {
    List<Leave> findByStatus(String status);
}
