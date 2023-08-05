package com.example.bonds_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bonds_backend.models.Security;
import com.example.bonds_backend.repository.SecurityRepository;

@RestController
@RequestMapping("/api/v1")
public class SecurityController {
    
    @Autowired
    private SecurityRepository securityRepository;

    @GetMapping("/getAllSecurities")
    public List<Security> getAll(){
        return securityRepository.findAll();
    }

    @GetMapping("/getSecurityById/{id}")
    public Security getById(@PathVariable long id){
        return securityRepository.findById(id).orElse(null);
    }

    @GetMapping("/getSecurityByUserId/{userId}")
    public List<Security> getByUserId(@PathVariable long userId){
        return securityRepository.findByUserId(userId);
    }
}
