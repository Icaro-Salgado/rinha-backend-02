package com.rinha.backend.controller.handler;

import com.rinha.backend.exception.InvalidInputException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(value = {EntityNotFoundException.class})
  ResponseEntity<?> handleEntityNotFound() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(
      value = {
        InvalidInputException.class,
        MethodArgumentNotValidException.class,
        HttpMessageNotReadableException.class
      })
  ResponseEntity<?> handleInvalidInput() {

    return ResponseEntity.unprocessableEntity().build();
  }
}
