package com.thomazllr.controller.handler;


import com.thomazllr.exception.ForkifySearchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ForkifySearchException.class)
    public ResponseEntity<Problem> handleEntityNotFoundException(ForkifySearchException exception) {
        var status = HttpStatus.BAD_REQUEST;
        var problemType = ProblemType.BUSINESS_ERROR;
        String detail = exception.getMessage();

        var problemBuilder = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();

        return ResponseEntity.status(status).body(problemBuilder);

    }

    private Problem.ProblemBuilder createProblemBuilder(HttpStatusCode status,
                                                        ProblemType problemType, String detail) {
        return Problem.builder()
                .timestamp(OffsetDateTime.now(ZoneId.of("UTC")))
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail);
    }
}