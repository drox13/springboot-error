package com.dario.curso.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.html.parser.Entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.dario.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.dario.curso.springboot.error.springboot_error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<Error> divisionByZero(Exception exception){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por cero!");
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        //return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException e){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api Rest no encontrado");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception e){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "numero invalido o incorrecto , no tiene el formato de digito");
        error.put("message", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+"");

        return error;
    }

    @ExceptionHandler({NullPointerException.class, 
        HttpMessageNotWritableException.class,
        UserNotFoundException.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundExcetion(Exception e){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "El usuario o Role no existe");
        error.put("message", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+"");

        return error;
    }
}