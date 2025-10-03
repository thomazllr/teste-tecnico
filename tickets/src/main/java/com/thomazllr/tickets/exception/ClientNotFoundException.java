package com.thomazllr.tickets.exception;

public class ClientNotFoundException extends EntityNotFound {

    public ClientNotFoundException(Long id) {
        super("Client with id: '%d' not found.".formatted(id));
    }
}
