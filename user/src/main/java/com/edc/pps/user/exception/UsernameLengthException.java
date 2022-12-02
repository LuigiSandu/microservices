package com.edc.pps.user.exception;

public class UsernameLengthException extends RuntimeException{
    public UsernameLengthException(String message) {
        super(message);
    }
}
