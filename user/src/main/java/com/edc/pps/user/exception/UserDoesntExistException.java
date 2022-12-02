package com.edc.pps.user.exception;

public class UserDoesntExistException extends RuntimeException{
    public UserDoesntExistException(String message) {
        super(message);
    }
}
