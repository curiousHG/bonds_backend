package com.example.bonds_backend.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.bonds_backend.models.Trade;
import com.example.bonds_backend.repository.TradeRepository;

import org.springframework.web.bind.annotation.RequestBody;
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
    public Trade getById(@PathVariable long id){
            Trade tradeDetails = tradeRepo.findById(id).orElse(null);

            return tradeDetails;
    }

    @PostMapping("/saveTrade")
    public String createNewTrade(@RequestBody Trade tradeDetails){
        tradeRepo.save(tradeDetails);
        return "Added a New Trade";
    }

    @PostMapping("/updateTrade/{id}")
    public String updateTradeDetails(@PathVariable Long id, @RequestBody Trade tradeDetails){

        Trade existingTrade = tradeRepo.findById(id).orElse(null);

        if(existingTrade.equals(null)){
            return "No such trade exists. Please retry.";
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

        return "Successfully Updated.";
        
    }



}
