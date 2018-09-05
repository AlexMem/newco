package com.andreitop.newco.error_api_object;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ErrorApiObject implements Serializable {
    private final HttpStatus code;
    private final String message;
    private final LocalDateTime timestamp;

    public ErrorApiObject(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
