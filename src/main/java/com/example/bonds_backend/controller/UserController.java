package com.example.bonds_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bonds_backend.repository.UserRepository;
import com.example.bonds_backend.models.User;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserRepository repository;
    
    @PostMapping("/addUser")
    public ResponseEntity<Object> saveUser(@RequestBody User user){
        return ResponseEntity.ok(repository.save(user));
    }

    @GetMapping("/getAllUsers")
    @CrossOrigin(origins = "*")
    public List<User> getAll(){
        return repository.findAll();
    }

    @GetMapping("/getUserById/{id}")  
    @CrossOrigin(origins = "*")
    private ResponseEntity<Object> getById(@PathVariable long id){
        Optional<User> user = repository.findById(id);
        if(user == null || user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Security not found");
        }
        return ResponseEntity.ok(user.get());
    }

    @DeleteMapping("/deleteUser/{id}")
    @CrossOrigin(origins = "*")
    private String deleteUser(@PathVariable long id){
        repository.deleteById(id);
        return "Deleted user Successfully";
    }

    @PutMapping("/updateUser/{id}")
    @CrossOrigin(origins = "*")
    private User updateUser(@PathVariable long id, @RequestBody User updatedUser){
        User user = repository.findById(id).orElse(null);
        if(user != null){
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            repository.save(user);
            return user;
        }else{
            return null;
        }
    }

    @PostMapping("/signin")
    @CrossOrigin(origins = "*")
    private String signin(@RequestBody User user){
        return "this is Sign in API";
    }
}
