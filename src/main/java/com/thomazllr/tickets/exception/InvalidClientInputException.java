package com.thomazllr.tickets.exception;

public class InvalidClientInputException extends InvalidInputException {
    public InvalidClientInputException(Long id) {
        super("Cannot create ticket: client '%d' is invalid or does not exist.".formatted(id));
    }
}