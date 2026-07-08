package org.example.employee_management.service;

import org.example.employee_management.dto.Leave_reqsRequest;
import org.example.employee_management.dto.Leave_reqsResponse;
import org.example.employee_management.dto.MessageResponse;
import org.example.employee_management.entity.Employee;
import org.example.employee_management.entity.Leave_reqs;
import org.example.employee_management.exception.ResourceNotFoundException;
import org.example.employee_management.mapper.Leave_reqsMapper;
import org.example.employee_management.repository.Employeerepository;
import org.springframework.stereotype.Service;
import org.example.employee_management.repository.Leaverepository;
import java.util.List;

@Service
public class Leaveservice {

    private final Leaverepository repository;
    private final Employeerepository employeeRepository;

    public Leaveservice(Leaverepository repository,Employeerepository employeeRepository) {
        this.repository = repository;
        this.employeeRepository=employeeRepository;
    }

    // Add leave
    public Leave_reqsResponse addLeave(Leave_reqsRequest request) {

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found"));

        Leave_reqs leave = new Leave_reqs();

        leave.setStartDate(request.getStartDate());
        leave.setEndDate(request.getEndDate());
        leave.setReason(request.getReason());
        leave.setStatus(request.getStatus());
        leave.setEmployee(employee);

        leave = repository.save(leave);

        return Leave_reqsMapper.toResponse(leave);
    }

    // View All leaves
    public List<Leave_reqsResponse> getAllLeaves() {

        return repository.findAll()
                .stream()
                .map(Leave_reqsMapper::toResponse)
                .toList();

    }

    // Search leave by ID
    public Leave_reqsResponse getLeaveById(Integer id) {

        Leave_reqs leave = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Leave request with id " + id + " not found"));

        return Leave_reqsMapper.toResponse(leave);

    }

    // Update leave
    public Leave_reqsResponse updateLeave(Integer id, Leave_reqsRequest request) {

        Leave_reqs leave = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Leave request with id " + id + " not found"));

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found"));

        leave.setStartDate(request.getStartDate());
        leave.setEndDate(request.getEndDate());
        leave.setReason(request.getReason());
        leave.setStatus(request.getStatus());
        leave.setEmployee(employee);

        leave = repository.save(leave);

        return Leave_reqsMapper.toResponse(leave);
    }

    // Delete leave
    public MessageResponse deleteLeave(Integer id) {

        Leave_reqs leave = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Leave request with id " + id + " not found"));

        repository.delete(leave);

        return new MessageResponse(
                "Leave request deleted successfully."
        );

    }

    public List<Leave_reqsResponse> searchByStatus(String status) {

        return repository.findByStatus(status)
                .stream()
                .map(Leave_reqsMapper::toResponse)
                .toList();

    }

}
