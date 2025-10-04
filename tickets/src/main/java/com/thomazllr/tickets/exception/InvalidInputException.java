package com.thomazllr.tickets.exception;

public abstract class InvalidInputException extends RuntimeException {

    protected InvalidInputException(String message) {
        super(message);
    }
}