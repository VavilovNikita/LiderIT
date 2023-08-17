package com.liderit.liderit.advice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler
    public EntityNotFoundException handleNotFound(EntityNotFoundException e) {
        return e;
    }
}
