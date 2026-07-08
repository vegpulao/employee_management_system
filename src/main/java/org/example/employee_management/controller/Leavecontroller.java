package org.example.employee_management.controller;

import jakarta.validation.Valid;
import org.example.employee_management.dto.Leave_reqsRequest;
import org.example.employee_management.dto.Leave_reqsResponse;
import org.example.employee_management.dto.MessageResponse;
import org.example.employee_management.entity.Leave_reqs;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.example.employee_management.service.Leaveservice;

import java.util.List;

@RequestMapping("/leaves")
@RestController
public class Leavecontroller {
    private final Leaveservice service;

    public Leavecontroller(Leaveservice service) {

        this.service = service;
    }
    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @PostMapping
    public Leave_reqsResponse addLeave(
            @Valid @RequestBody Leave_reqsRequest request) {

        return service.addLeave(request);

    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Leave_reqsResponse> getAllLeaves() {

        return service.getAllLeaves();

    }
    @GetMapping("/{id}")
    public Leave_reqsResponse getLeaveById(
            @PathVariable Integer id) {

        return service.getLeaveById(id);

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public MessageResponse deleteLeave(
            @PathVariable Integer id) {

        return service.deleteLeave(id);

    }
    @PutMapping("/{id}")
    public Leave_reqsResponse updateLeave(
            @PathVariable Integer id,
            @Valid @RequestBody Leave_reqsRequest request) {

        return service.updateLeave(id, request);

    }
    @GetMapping("/search/status/{status}")
    public List<Leave_reqsResponse> searchByStatus(
            @PathVariable String status) {

        return service.searchByStatus(status);

    }
}