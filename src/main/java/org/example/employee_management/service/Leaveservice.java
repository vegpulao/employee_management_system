package org.example.employee_management.service;

import org.example.employee_management.entity.Employee;
import org.example.employee_management.entity.Leave;
import org.example.employee_management.exception.ResourceNotFoundException;
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
    public Leave getLeaveById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave request with id " + id + " not found"));
    }

    // Update leave
    public Leave updateLeave(Integer id, Leave leave_request) {

        repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave request with id " + id + " not found"));

        leave_request.setId(id);

        return repository.save(leave_request);
    }

    // Delete leave
    public void deleteLeave(Integer id) {
        Leave leave_request = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + id + " not found"));

        repository.delete(leave_request);
    }
}
