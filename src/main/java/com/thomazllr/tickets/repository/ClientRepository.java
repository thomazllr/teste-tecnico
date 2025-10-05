package com.thomazllr.tickets.repository;

import com.thomazllr.tickets.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
