package com.example.demo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NotFindException.class)
    public ResponseEntity<Object> notFind(NotFindException e, HttpServletRequest request) {
        return ResponseEntity.status(422).body("ID nao encontrado na base de dados");
    }
}
