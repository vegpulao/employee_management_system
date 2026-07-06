package org.example.employee_management.service;

import org.example.employee_management.entity.Leave;
import org.springframework.stereotype.Service;
import org.example.employee_management.repository.Leaverepository;
import java.util.List;
import java.util.Optional;

@Service
public class Leaveservice {

    private final Leaverepository repository;

    public Leaveservice(Leaverepository repository) {
        this.repository = repository;
    }

    // Add leave
    public Leave addLeave(Leave leave_request) {
        return repository.save(leave_request);
    }

    // View All leaves
    public List<Leave> getAllLeaves() {
        return repository.findAll();
    }

    // Search leave by ID
    public Optional<Leave> getLeaveById(Integer id) {
        return repository.findById(id);
    }

    // Update leave
    public Leave updateLeave(Leave leave_request) {
        return repository.save(leave_request);
    }

    // Delete leave
    public void deleteLeave(Integer id) {
        repository.deleteById(id);
    }
}
