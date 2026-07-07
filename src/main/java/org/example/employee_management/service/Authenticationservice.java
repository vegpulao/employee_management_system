package org.example.employee_management.service;

import org.example.employee_management.entity.AppUser;
import org.example.employee_management.repository.AppUserrepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Authenticationservice {

    private final AppUserrepository repository;
    private final PasswordEncoder passwordEncoder;

    // Authentication
    public Authenticationservice(AppUserrepository repository,
                                 PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
    // Registration
    public AppUser register(AppUser appUser) {

        appUser.setPassword(
                passwordEncoder.encode(appUser.getPassword())
        );

        return repository.save(appUser);
    }

}
