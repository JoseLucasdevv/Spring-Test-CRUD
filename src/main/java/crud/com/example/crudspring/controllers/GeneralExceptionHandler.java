package crud.com.example.crudspring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import crud.com.example.crudspring.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GeneralExceptionHandler {

@ExceptionHandler(BadRequestException.class)
 private ResponseEntity<Object> handleBadRequest(BadRequestException exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
  }