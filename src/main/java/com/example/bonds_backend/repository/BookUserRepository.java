package com.example.bonds_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bonds_backend.models.BookUser;



@Repository
public interface BookUserRepository extends JpaRepository<BookUser,Long>{

    List<BookUser> findByUser_Id(Long userId);


}
