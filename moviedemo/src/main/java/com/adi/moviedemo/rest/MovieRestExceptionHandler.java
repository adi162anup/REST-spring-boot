package com.adi.moviedemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException(MovieNotFoundException exc){

        MovieErrorResponse err = new MovieErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exc.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException(Exception exc){

        MovieErrorResponse err = new MovieErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(exc.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }
}
