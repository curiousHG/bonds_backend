package com.example.bonds_backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bonds_backend.repository.UserRepository;
import com.example.bonds_backend.models.User;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @PostMapping("/addUser")
    public String saveUser(@RequestBody User user){
        repository.save(user);
        return "Added user with id: " + user.getId();
    }

    @GetMapping("/getAllUsers")
    public List<User> getAll(){
        return repository.findAll();
    }
}
