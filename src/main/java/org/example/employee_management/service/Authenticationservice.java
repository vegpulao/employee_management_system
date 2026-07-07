package org.example.employee_management.service;

import org.example.employee_management.dto.LoginRequest;
import org.example.employee_management.entity.AppUser;
import org.example.employee_management.repository.AppUserrepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Authenticationservice {

    private final AuthenticationManager authenticationManager;
    private final AppUserrepository repository;
    private final PasswordEncoder passwordEncoder;

    // Authentication
    public Authenticationservice(AppUserrepository repository,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }
    // Registration
    public AppUser register(AppUser appUser) {

        appUser.setPassword(
                passwordEncoder.encode(appUser.getPassword())
        );

        return repository.save(appUser);
    }
    public String login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        return "Login Successful";
    }

}
