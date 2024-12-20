package com.test.commonutils;

public class CustomCheckedException extends Exception{


    // Constructor with custom message
    public CustomCheckedException(String message) {
        super(message);
    }

    // Constructor with custom message and cause
    public CustomCheckedException(String message, Throwable cause) {
        super(message, cause);
    }


}
