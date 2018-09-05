package com.andreitop.newco.exception_handler;

import com.andreitop.newco.error_api_object.ErrorApiObject;
import com.andreitop.newco.exceptions.TripNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class TripExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpStatus responseStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ErrorApiObject(responseStatus, "Validation error"),
                                    responseStatus);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpStatus responseStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ErrorApiObject(responseStatus, "Path variable is missing"),
                                    responseStatus);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        HttpStatus responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorApiObject(responseStatus, ex.getMessage()),
                                    responseStatus);
    }

    @ExceptionHandler(TripNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(TripNotFoundException ex, WebRequest request) {
        HttpStatus responseStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ErrorApiObject(responseStatus, ex.getMessage()),
                                    responseStatus);
    }
}
