package com.example.api.demo.Modelo.Exceptions;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.api.demo.Services.Exceptions.ObjectBadResquest;
import com.example.api.demo.Services.Exceptions.ObjectNotFoudExceptions;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ObjectNotFoudExceptions.class)
    public ResponseEntity<ModeloStandarError> objectNotFound(ObjectNotFoudExceptions ex, HttpServletRequest request){
        ModeloStandarError error = new ModeloStandarError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler(ObjectBadResquest.class)
    public ResponseEntity<ModeloStandarError> ObjectBad(ObjectBadResquest ex, HttpServletRequest request){
        ModeloStandarError error = new ModeloStandarError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
}
