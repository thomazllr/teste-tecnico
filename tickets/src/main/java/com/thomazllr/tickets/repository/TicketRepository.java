package com.thomazllr.tickets.repository;

import com.thomazllr.tickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("from Ticket t join fetch t.client join fetch t.module")
    List<Ticket> findAll();
}
