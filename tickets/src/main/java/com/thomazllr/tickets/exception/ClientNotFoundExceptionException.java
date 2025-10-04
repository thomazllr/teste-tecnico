package com.thomazllr.tickets.exception;

public class ClientNotFoundExceptionException extends EntityNotFoundException {

    public ClientNotFoundExceptionException(Long id) {
        super("Client with id: '%d' not found.".formatted(id));
    }
}
