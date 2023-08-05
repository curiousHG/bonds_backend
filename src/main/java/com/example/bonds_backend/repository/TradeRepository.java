package com.example.bonds_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.bonds_backend.models.Trade;

public interface TradeRepository extends JpaRepository<Trade,Long> {
    
}
