package org.example.employee_management.repository;

import org.example.employee_management.entity.Leave_reqs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Leaverepository extends JpaRepository<Leave_reqs,Integer> {
    List<Leave_reqs> findByStatus(String status);
}
