package com.thomazllr.tickets.repository;

import com.thomazllr.tickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("""
                SELECT t
                FROM Ticket t 
                JOIN FETCH t.client 
                JOIN FETCH t.module 
                WHERE (t.openingDate >= :startDate AND t.openingDate < :endDate)
                   OR (t.closingDate >= :startDate AND t.closingDate < :endDate)
            """)
    List<Ticket> findAllByMonthAndYear(@Param("startDate") LocalDate startDate,
                                       @Param("endDate") LocalDate endDate);

}
