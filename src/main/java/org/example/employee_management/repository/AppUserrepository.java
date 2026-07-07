package org.example.employee_management.repository;

import org.example.employee_management.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserrepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByUsername(String username);

}
