package com.example.BankApp.user.repository;

import com.example.BankApp.user.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByName(String name);
}
