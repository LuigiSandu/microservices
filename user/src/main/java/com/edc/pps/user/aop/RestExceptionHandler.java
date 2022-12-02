package com.edc.pps.user.aop;

import com.edc.pps.user.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> userAlreadyExistsException(UserAlreadyExistsException exception) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Timestamp: ", LocalDateTime.now());
        body.put("Message:", exception.getLocalizedMessage());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UserDoesntExistException.class)
    public ResponseEntity<Object> userDoesntExistException(UserDoesntExistException exception) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Timestamp: ", LocalDateTime.now());
        body.put("Message:", exception.getLocalizedMessage());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UsernameLengthException.class)
    public ResponseEntity<Object> usernameLengthException(UsernameLengthException exception) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Timestamp: ", LocalDateTime.now());
        body.put("Message:", exception.getLocalizedMessage());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(PasswordLengthException.class)
    public ResponseEntity<Object> passwordLengthException(PasswordLengthException exception) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Timestamp: ", LocalDateTime.now());
        body.put("Message:", exception.getLocalizedMessage());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

}
