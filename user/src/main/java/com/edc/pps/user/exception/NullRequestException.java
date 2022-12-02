package com.edc.pps.user.exception;

public class NullRequestException extends  RuntimeException{
    public NullRequestException(String message) {
        super(message);
    }
}
