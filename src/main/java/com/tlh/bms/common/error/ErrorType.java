package com.tlh.bms.common.error;

import org.springframework.http.HttpStatus;

public enum ErrorType {

    STRIPE_ERROR("Error on charging!", HttpStatus.SERVICE_UNAVAILABLE),
    VALIDATION_FAILED("Validation failed!", HttpStatus.BAD_REQUEST);

    private String message;
    private HttpStatus status;

    public String getMessage() {
        return this.message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    private ErrorType(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
