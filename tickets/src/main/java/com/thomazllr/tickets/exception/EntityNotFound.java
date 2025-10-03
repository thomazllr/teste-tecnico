package com.thomazllr.tickets.exception;

public abstract class EntityNotFound extends RuntimeException {

    public EntityNotFound(String message) {
        super(message);
    }
}
