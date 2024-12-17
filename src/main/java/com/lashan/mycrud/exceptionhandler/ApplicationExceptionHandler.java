package com.lashan.mycrud.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> hadleMethodArgumentException(MethodArgumentNotValidException ex){
        HashMap<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err ->{
            errorMap.put(err.getField(), err.getDefaultMessage());
        });
        return errorMap;
    }
}
