package com.example.spring_api_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        // Field-level errors
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        // Class-level errors
        ex.getBindingResult().getGlobalErrors().forEach(error -> {
            String key = switch (error.getCode()) {
                case "PasswordMatches" -> "confirmPassword";
                default -> error.getObjectName();
            };
            errors.put(key, error.getDefaultMessage());
        });



        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
