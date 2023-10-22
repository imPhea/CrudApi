package com.app.demo.exception;

public class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}