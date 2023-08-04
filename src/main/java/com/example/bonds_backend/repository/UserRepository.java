package com.example.bonds_backend.repository;

import com.example.bonds_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {


}
