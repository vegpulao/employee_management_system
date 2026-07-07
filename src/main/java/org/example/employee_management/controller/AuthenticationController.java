package org.example.employee_management.controller;

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
    public AppUser register(@RequestBody AppUser appUser) {
        return service.register(appUser);
    }
}
