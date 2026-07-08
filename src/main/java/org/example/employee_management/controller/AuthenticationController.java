package org.example.employee_management.controller;

import jakarta.validation.Valid;
import org.example.employee_management.dto.LoginRequest;
import org.example.employee_management.dto.LoginResponse;
import org.example.employee_management.dto.MessageResponse;
import org.example.employee_management.entity.AppUser;
import org.example.employee_management.service.Authenticationservice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final Authenticationservice service;

    public AuthenticationController(Authenticationservice service) {
        this.service = service;
    }

    @PostMapping("/register")
    public MessageResponse register(
            @Valid @RequestBody AppUser appUser) {
        return service.register(appUser);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody LoginRequest request) {
        return service.login(request);
    }
}
