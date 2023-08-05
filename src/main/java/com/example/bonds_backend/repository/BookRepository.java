package com.example.bonds_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bonds_backend.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
