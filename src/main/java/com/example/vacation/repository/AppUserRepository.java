package com.example.vacation.repository;

import com.example.vacation.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	public AppUser findByEmail(String email);
}
