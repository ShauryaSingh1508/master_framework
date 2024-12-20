package com.test.commonutils;

public class CustomRuntimeException extends RuntimeException{
    public CustomRuntimeException() {
        super("A custom runtime exception occurred");
    }

    // Constructor with custom message

    public CustomRuntimeException(String message) {
        super(message);
    }

    // Constructor with custom message and cause
    public CustomRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with cause
    public CustomRuntimeException(Throwable cause) {
        super(cause);
    }
}
