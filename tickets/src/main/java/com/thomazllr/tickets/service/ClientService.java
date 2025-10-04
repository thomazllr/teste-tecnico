package com.thomazllr.tickets.service;

import com.thomazllr.tickets.exception.ClientNotFoundExceptionException;
import com.thomazllr.tickets.exception.InvalidClientInputException;
import com.thomazllr.tickets.model.Client;
import com.thomazllr.tickets.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Client findByIdOrThrowNotFound(Long id) {
        return repository.findById(id).orElseThrow(() -> new ClientNotFoundExceptionException(id));
    }

    public Client findByIdOrThrowBadRequest(Long id) {
        return repository.findById(id).orElseThrow(() -> new InvalidClientInputException(id));
    }
}
