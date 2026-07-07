package org.example.employee_management.service;

import org.example.employee_management.entity.Leave_reqs;
import org.example.employee_management.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.example.employee_management.repository.Leaverepository;
import java.util.List;

@Service
public class Leaveservice {

    private final Leaverepository repository;

    public Leaveservice(Leaverepository repository) {
        this.repository = repository;
    }

    // Add leave
    public Leave_reqs addLeave(Leave_reqs leave_request) {
        return repository.save(leave_request);
    }

    // View All leaves
    public List<Leave_reqs> getAllLeaves() {
        return repository.findAll();
    }

    // Search leave by ID
    public Leave_reqs getLeaveById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave request with id " + id + " not found"));
    }

    // Update leave
    public Leave_reqs updateLeave(Integer id, Leave_reqs leave_request) {

        repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave request with id " + id + " not found"));

        leave_request.setId(id);

        return repository.save(leave_request);
    }

    // Delete leave
    public void deleteLeave(Integer id) {
        Leave_reqs leave_request = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + id + " not found"));

        repository.delete(leave_request);
    }
    public List<Leave_reqs> searchByStatus(String status) {
        return repository.findByStatus(status);
    }

}
