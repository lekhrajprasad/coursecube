package com.coursecube.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@ControllerAdvice
public class MyRestEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CustomerIDNotFoundException.class})
    public ResponseEntity<MyErrorMessage> handleCidNotFound(HttpServletResponse response) {
        MyErrorMessage errMsg = new MyErrorMessage();
        errMsg.setTimestamp(LocalDateTime.now());
        errMsg.setError("-----MyCustomer Id is Not Available Guys -------");
        errMsg.setStatus(HttpStatus.NOT_FOUND.value());
        System.out.println("===========================================");
        System.out.println(response.getLocale());
        System.out.println(response.getStatus());
        System.out.println("===========================================");
        return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidPhoneNumberException.class})
    public ResponseEntity<MyErrorMessage> handleInvalidPhoneNum(RuntimeException ex,
                                                                WebRequest request) {
        System.out.println("===========================================");
        ex.printStackTrace();
        System.out.println(request.getContextPath());
        System.out.println("===========================================");
        MyErrorMessage errMsg = new MyErrorMessage();
        errMsg.setTimestamp(LocalDateTime.now());
        errMsg.setError("-----Phone number not found -------");
        errMsg.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CityNotFoundException.class})
    public ResponseEntity<MyErrorMessage> handleCityNotFound(RuntimeException ex,
                                                                WebRequest request) {
        System.out.println("===========================================");
        ex.printStackTrace();
        System.out.println(request.getContextPath());
        System.out.println("===========================================");
        MyErrorMessage errMsg = new MyErrorMessage();
        errMsg.setTimestamp(LocalDateTime.now());
        errMsg.setError("-----City not found -------");
        errMsg.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
    }
}
