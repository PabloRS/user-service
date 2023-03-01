package com.connectbase.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ UserServiceException.class })
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<Object> handleExceptionUser(Exception ex, WebRequest request) {
        return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
    }
}
