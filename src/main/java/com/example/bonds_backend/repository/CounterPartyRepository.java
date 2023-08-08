package com.example.bonds_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bonds_backend.models.BookUser;
import com.example.bonds_backend.models.Counterparty;


@Repository
public interface CounterPartyRepository extends JpaRepository<Counterparty,Long>{


}