package com.magusabdul.miniprojectspringboot.models.repos;

import java.util.Optional;

import com.magusabdul.miniprojectspringboot.models.entities.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long>{
    
    Optional<AppUser> findByEmail(String email);
    
}
