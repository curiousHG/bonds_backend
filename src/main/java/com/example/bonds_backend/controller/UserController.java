package com.example.bonds_backend.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bonds_backend.repository.BookUserRepository;
import com.example.bonds_backend.repository.TradeRepository;
import com.example.bonds_backend.repository.UserRepository;
import com.example.bonds_backend.models.BookUser;
import com.example.bonds_backend.models.Trade;
import com.example.bonds_backend.models.User;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    BookUserRepository bookUserRepository;
    
    @Autowired
    private TradeRepository tradeRepo;

    @PostMapping("/addUser")
    public ResponseEntity<Object> saveUser(@RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("role") String role){
                
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
       
        if ("username".equals(user.getEmail()) && "password".equals(user.getPassword())) {
            // Authentication successful
            return ResponseEntity.ok("Login successful");
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
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

    @GetMapping("/getRecentTrades/{id}")
    @CrossOrigin(origins = "*")
    public List<Trade> getRecentTrades(@PathVariable long id){

            List<BookUser> bookUserList = bookUserRepository.findByUser_Id(id);

            List<Long> bookIds = bookUserList.stream()
                .map(bookUser -> bookUser.getBook().getId())
                .collect(Collectors.toList());

            return tradeRepo.findByBookIdIn(bookIds);
    }

}
