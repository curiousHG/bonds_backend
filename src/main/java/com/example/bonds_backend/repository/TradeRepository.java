package com.example.bonds_backend.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.bonds_backend.models.Trade;

public interface TradeRepository extends JpaRepository<Trade,Long> {

    List<Trade> findByBookIdIn(List<Long> bookIds);
    
    
}
