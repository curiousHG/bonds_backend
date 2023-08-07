package com.example.bonds_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.bonds_backend.models.Trade;

public interface TradeRepository extends JpaRepository<Trade,Long> {

    // @Query("SELECT t FROM Trade t WHERE t.security_id = ?1")
    // List<Trade> findBySecurityId(long securityId);
    
}
