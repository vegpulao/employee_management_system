package org.example.employee_management.repository;

import org.example.employee_management.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Leaverepository extends JpaRepository<Leave,Integer> {

}
