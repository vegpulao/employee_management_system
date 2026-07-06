package org.example.employee_management.repository;

import org.example.employee_management.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Taskrepository extends JpaRepository<Task, Integer> {

}
