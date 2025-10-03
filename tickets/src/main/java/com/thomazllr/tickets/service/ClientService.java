package com.thomazllr.tickets.service;

import com.thomazllr.tickets.exception.ClientNotFoundException;
import com.thomazllr.tickets.model.Client;
import com.thomazllr.tickets.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Client findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }
}
