package com.example.bonds_backend.controller;

import java.util.List;
import java.util.Optional;
// import map from string to string
import java.util.Map;

import org.apache.logging.log4j.simple.SimpleLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.bonds_backend.models.Security;
import com.example.bonds_backend.models.Trade;
import com.example.bonds_backend.repository.SecurityRepository;



@RestController
@RequestMapping("/api/v1")

public class SecurityController {
    
    @Autowired
    private SecurityRepository securityRepository;

    @GetMapping("/getAllSecurities")
    @CrossOrigin(origins = "*")
    public List<Security> getAll(){
        return securityRepository.findAll();
    }

    @GetMapping("/getSecurityById/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> getById(@PathVariable long id){
        Optional<Security> securities = securityRepository.findById(id);
        if (securities.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Security not found");
        }
        return ResponseEntity.ok(securities.get());
    }

    @GetMapping("/getSecurityByUserId/{userId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> getByUserId(@PathVariable long userId){
        List<Security> securities= securityRepository.findByUserId(userId);
        if (securities.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Security not found");
        }
        return ResponseEntity.ok(securities);
    }

    @GetMapping("/getTradesBySecurity/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> getTradesBySecurity(@PathVariable long id) {
        Security foundSecurity = securityRepository.findById(id).orElse(null);
        if (foundSecurity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Security not found");
        }
        
        List<Trade> trades = securityRepository.findTradeBySecurityId_Id(foundSecurity.getId());

        return ResponseEntity.ok(trades);
    }


    @PostMapping("/getSecurityByDateRange")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> getByDateRange(@RequestBody Map<String, String> dates){
        String startDate = dates.get("startDate");
        String endDate = dates.get("endDate");
        List<Security> securities= securityRepository.findByDateRange(startDate, endDate);
        return ResponseEntity.ok(securities);
    }

    @PostMapping(value="/createSecurity")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> postMethodName(@RequestBody Security security) {
        if(securityRepository.findByISIN(security.getISIN()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Security with ISIN "+ security.getISIN()+" already exists");
        }
        // check all parameters are present and are correct
        if( security.getISIN() == null || 
            security.getCUSIP() == null || 
            security.getIssuer() == null || 
            security.getMaturityDate() == null ||
            security.getCoupon() == 0 || 
            security.getType() == null || 
            security.getFaceValue() == 0 || 
            security.getStatus() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing parameters");
        }
        return ResponseEntity.ok(securityRepository.save(security));
    }

    @PostMapping(value="/updateSecurity")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> updateMethodName(@RequestBody Security security) {
        if (security.getISIN() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing ISIN");
        }
        Security existingSecurity = securityRepository.findByISIN(security.getISIN());
        if (existingSecurity == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Security with ISIN " + security.getISIN() + " not found");
        }
        existingSecurity.setCUSIP(security.getCUSIP());
        existingSecurity.setCoupon(security.getCoupon());
        existingSecurity.setFaceValue(security.getFaceValue());
        existingSecurity.setIssuer(security.getIssuer());
        existingSecurity.setMaturityDate(security.getMaturityDate());
        existingSecurity.setStatus(security.getStatus());
        existingSecurity.setType(security.getType());
        securityRepository.save(existingSecurity);
        return ResponseEntity.ok(existingSecurity);
    }

    @PostMapping(value="/deleteSecurity")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> deleteMethodName(@RequestBody Security security) {
        if (security.getISIN() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing ISIN");
        }
        Security existingSecurity = securityRepository.findByISIN(security.getISIN());
        if (existingSecurity == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Security with ISIN " + security.getISIN() + " not found");
        }

        // List<Trade> trades = securityRepository.findTradeBySecurityId_Id(existingSecurity.getId());

        // if (trades.size() > 0) {
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Security with ISIN " + security.getISIN() + " has trades");
        // }
        // securityRepository.delete(existingSecurity);
        securityRepository.deleteSecurity(existingSecurity.getId());

        // check if security has trades to it

        return ResponseEntity.ok("Security with ISIN " + security.getISIN() + " deleted");
    }
}
