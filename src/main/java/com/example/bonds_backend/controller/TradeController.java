package com.example.bonds_backend.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import com.example.bonds_backend.models.Trade;
import com.example.bonds_backend.repository.TradeRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1")
public class TradeController {

    private static final Trade GlobalExceptionHandler = null;
    @Autowired
    private TradeRepository tradeRepo;

    @GetMapping("/getTradeById/{id}")
   public ResponseEntity<Object> getById(@PathVariable long id){
            Optional<Trade> tradeDetails = tradeRepo.findById(id);

            if(tradeDetails.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Security not found");
            }

            return ResponseEntity.ok(tradeDetails.get());
    }


    @PostMapping("/saveTrade")
    public ResponseEntity<Object> createNewTrade(@RequestBody Trade tradeDetails){
       return ResponseEntity.ok(tradeRepo.save(tradeDetails));
    }

    @PostMapping("/updateTrade/{id}")
    public ResponseEntity<Object> updateTradeDetails(@PathVariable Long id, @RequestBody Trade tradeDetails){

        Trade existingTrade = tradeRepo.findById(id).orElse(null);

        if(existingTrade.equals(null)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing ISIN");
        }

        existingTrade.setPrice(tradeDetails.getPrice());
        existingTrade.setSecurity(tradeDetails.getSecurity());
        existingTrade.setBook(tradeDetails.getBook());
        existingTrade.setQuantity(tradeDetails.getQuantity());
        existingTrade.setStatus(tradeDetails.getStatus());
        existingTrade.setSettlementDate(tradeDetails.getSettlementDate());
        existingTrade.setCounterParty(tradeDetails.getCounterParty());
        existingTrade.setTradeDate(tradeDetails.getTradeDate());
        existingTrade.setBuySell(tradeDetails.getBuySell());

        tradeRepo.save(existingTrade);

        return ResponseEntity.ok(existingTrade);
        
    }

    @GetMapping("/getTradeSecurity/{id}")
    public ResponseEntity<Object> getSecurtiy(@PathVariable Long id){

        Trade tradeDetails = tradeRepo.findById(id).orElse(null);

        if(tradeDetails.equals(null)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such trade exists.");
        }

        return ResponseEntity.ok(tradeDetails.getSecurity());

    }


}
