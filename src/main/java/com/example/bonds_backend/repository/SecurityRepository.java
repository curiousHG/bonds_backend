package com.example.bonds_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bonds_backend.models.Security;
import org.springframework.data.jpa.repository.Query;

public interface SecurityRepository extends JpaRepository<Security, Long> {

    
    @Query(value = "SELECT *" +
        " FROM security s" +
        " JOIN trade t ON s.id = t.security_id" +
        " JOIN book_user bu ON t.book_id = bu.book_id" +
        " JOIN users u ON bu.user_id = u.id" +
        " WHERE u.id = ?1", nativeQuery = true)

    List<Security> findByUserId(long userId);

    Security findByISIN(String ISIN);

    @Query(value = "SELECT *" +
        " FROM security s" +
        " WHERE s.maturity_date BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Security> findByDateRange(String startDate, String endDate);

}

