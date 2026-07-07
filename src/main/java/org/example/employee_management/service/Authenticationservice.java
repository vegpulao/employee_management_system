package org.example.employee_management.service;

import org.example.employee_management.dto.LoginRequest;
import org.example.employee_management.dto.LoginResponse;
import org.example.employee_management.dto.MessageResponse;
import org.example.employee_management.entity.AppUser;
import org.example.employee_management.repository.AppUserrepository;
import org.example.employee_management.security.Jwtservice;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Authenticationservice {

    private final AuthenticationManager authenticationManager;
    private final AppUserrepository repository;
    private final PasswordEncoder passwordEncoder;
    private final Jwtservice jwtservice;

    // Authentication
    public Authenticationservice(AppUserrepository repository,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager,
                                 Jwtservice jwtservice) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtservice = jwtservice;
    }
    // Registration
    public MessageResponse register(AppUser appUser) {

        appUser.setPassword(
                passwordEncoder.encode(appUser.getPassword())
        );

        repository.save(appUser);

        return new MessageResponse("User registered successfully.");
    }
    public LoginResponse login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        AppUser user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        String token = jwtservice.generateToken(
                user.getUsername()
        );
        return new LoginResponse(
                token,
                user.getUsername(),
                user.getRole()
        );
    }

}
