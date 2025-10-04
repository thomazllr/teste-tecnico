package com.thomazllr.tickets.controller.handler;

import com.thomazllr.tickets.exception.EntityNotFoundException;
import com.thomazllr.tickets.exception.InvalidInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.DateTimeException;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Problem> handleEntityNotFoundException(EntityNotFoundException exception) {
        var status = HttpStatus.NOT_FOUND;
        var problemType = ProblemType.RESOURCE_NOT_FOUND;
        String detail = exception.getMessage();

        var problemBuilder = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();

        return ResponseEntity.status(status).body(problemBuilder);

    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Problem> handleEntityNotFoundException(InvalidInputException exception) {
        var status = HttpStatus.BAD_REQUEST;
        var problemType = ProblemType.BUSINESS_ERROR;
        String detail = exception.getMessage();

        var problemBuilder = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();

        return ResponseEntity.status(status).body(problemBuilder);

    }

    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<Problem> handleEntityNotFoundException(DateTimeException exception) {
        var status = HttpStatus.BAD_REQUEST;
        var problemType = ProblemType.BUSINESS_ERROR;
        String detail = exception.getMessage();

        var problemBuilder = createProblemBuilder(status, problemType, detail)
                .userMessage("Invalid month of the year. Enter a valid month and try again.")
                .build();

        return ResponseEntity.status(status).body(problemBuilder);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Problem> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var problemType = ProblemType.INVALID_DATA;
        var detail = "One or more fields are invalid. Correct and enter the correct values and try again.";
        var bindingResult = exception.getBindingResult();
        var status = exception.getStatusCode();

        List<Problem.Object> objectErros = bindingResult.getFieldErrors().stream()
                .map(objectError -> {
                    String message = objectError.getDefaultMessage();
                    return Problem.Object.builder()
                            .name(objectError.getField())
                            .userMessage(message)
                            .build();
                }).toList();

        var problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .objects(objectErros)
                .build();

        return ResponseEntity.status(status).body(problem);

    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Problem> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        var problemType = ProblemType.INVALID_PARAMETER;
        var status = HttpStatus.BAD_REQUEST;
        String detail = String.format("The URL parameter '%s' was assigned the value '%s', "
                                      + "which is of an invalid type. Correct and enter a value compatible with type %s.",
                exception.getName(), exception.getValue(), exception.getRequiredType().getSimpleName());


        var problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();


        return ResponseEntity.status(status).body(problem);
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
