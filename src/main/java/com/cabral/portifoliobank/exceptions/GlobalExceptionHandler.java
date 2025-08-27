package com.cabral.portifoliobank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex){
        String mensagemErro = ex.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.badRequest().body(mensagemErro);
    }

    @ExceptionHandler(IllegalArgumentException.class) public ResponseEntity<Object> handleArgumentExceptions(IllegalArgumentException ex) {
        String mensagemErro = ex.getMessage();
        return ResponseEntity.badRequest().body(mensagemErro);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeExceptions(RuntimeException ex) {
        String mensagemErro = ex.getMessage();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagemErro);
    }

}
