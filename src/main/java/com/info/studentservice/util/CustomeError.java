package com.info.studentservice.util;

import org.springframework.http.HttpStatus;

public class CustomeError {
    String message;
    HttpStatus status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public CustomeError() {
    }

    public CustomeError(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
