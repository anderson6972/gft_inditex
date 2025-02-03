package com.inditex.gft.infrastructure.adapter.in.rest;

import com.inditex.gft.models.Error;
import com.inditex.gft.domain.exception.PriceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    //para controlar las busquedas sin resultados
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Error> handlePriceNotFoundException(PriceNotFoundException ex, HttpServletRequest request) {
        Error errorResponse = new Error();
        errorResponse.setTimestamp(OffsetDateTime.now());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setError("Not Found");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //Para errores de formato
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        Error errorResponse = new Error();
        errorResponse.setTimestamp(OffsetDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("Bad Request");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Para otros tipos de excepciones
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGeneralException(Exception ex, HttpServletRequest request) {
        Error errorResponse = new Error();
        errorResponse.setTimestamp(OffsetDateTime.now());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setError("Internal Server Error");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

