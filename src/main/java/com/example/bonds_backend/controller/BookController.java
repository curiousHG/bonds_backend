package com.example.bonds_backend.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.bonds_backend.models.Book;
import com.example.bonds_backend.models.BookUser;
import com.example.bonds_backend.models.Security;
import com.example.bonds_backend.models.Trade;
import com.example.bonds_backend.repository.BookRepository;
import com.example.bonds_backend.repository.TradeRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1")

public class BookController {

    @Autowired
    private BookRepository bookRepo;

    @GetMapping("/getBookById/{id}")
    @CrossOrigin(origins = "*")

    public ResponseEntity<Object> getById(@PathVariable long id){
        Optional<Book> bookDetails = bookRepo.findById(id);

        if(bookDetails.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Security not found");
        }

        return ResponseEntity.ok(bookDetails.get());
    }



    
}
