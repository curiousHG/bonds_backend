package com.example.bonds_backend.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "counter_party_id", referencedColumnName = "id")
    private Counterparty counterParty;

    @ManyToOne
    @JoinColumn(name = "security_id", referencedColumnName = "id")
    private Security security;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private double price;

    @Column(name = "buy_sell", nullable = false)
    private String buySell;

    @Column(name = "trade_date", nullable = false)
    private Date tradeDate;

    @Column(name = "settlement_date", nullable = false)
    private Date settlementDate;
}

