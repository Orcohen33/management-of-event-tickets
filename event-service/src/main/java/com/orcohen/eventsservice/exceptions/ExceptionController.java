package com.orcohen.eventsservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = { EventNotFoundException.class })
    public ResponseEntity<Object> handleEventNotFoundException(EventNotFoundException ex) {
        // Build the error response body
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", ex.getMessage());

        // Build the HTTP response entity with the error response body and the status code
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }

    @ExceptionHandler(value = { InvalidEventException.class })
    public ResponseEntity<Object> handleInvalidEventException(InvalidEventException ex) {
        // Build the error response body
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", ex.getMessage());

        // Build the HTTP response entity with the error response body and the status code
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

}
