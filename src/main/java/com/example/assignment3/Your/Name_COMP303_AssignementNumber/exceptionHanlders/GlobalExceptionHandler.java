package com.example.assignment3.Your.Name_COMP303_AssignementNumber.exceptionHanlders;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.assignment3.Your.Name_COMP303_AssignementNumber.commonModels.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleInvalidArguments(MethodArgumentNotValidException exception) {

        // ErrorResponse errorResponse = new ErrorResponse();

        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        int httpErrorCode = status.value();
        String httpError = status.toString();
        List<Map<String, String>> errorList = new ArrayList<>();

        Map<String, String> errors = new HashMap<String, String>();

        for (var error : exception.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }

        errorList.add(errors);

        // errorResponse.setTimestamp(timestamp);
        // errorResponse.setHttpError(httpError);
        // errorResponse.setHttpErrorCode(httpErrorCode);
        // errorResponse.setErrorList(errorList);

        ErrorResponse errorResponse = ErrorResponse.builder().timestamp(timestamp)
                .httpError(httpError)
                .httpErrorCode(httpErrorCode)
                .errorList(errorList)
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> noSuchElementHandle(NoSuchElementException exception) {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        int httpErrorCode = status.value();
        String httpError = status.toString();
        List<Map<String, String>> errorList = new ArrayList<>();

        Map<String, String> errors = new HashMap<String, String>();

      
        errors.put(exception.getClass().getName(), exception.getMessage());
        errorList.add(errors);

        ErrorResponse errorResponse = ErrorResponse.builder().timestamp(timestamp)
                .httpError(httpError)
                .httpErrorCode(httpErrorCode)
                .errorList(errorList)
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllException(Exception exception) {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        int httpErrorCode = status.value();
        String httpError = status.toString();
        List<Map<String, String>> errorList = new ArrayList<>();

        Map<String, String> errors = new HashMap<String, String>();

        errors.put(exception.getClass().getName(), exception.getMessage());

        errorList.add(errors);

        ErrorResponse errorResponse = ErrorResponse.builder().timestamp(timestamp)
                .httpError(httpError)
                .httpErrorCode(httpErrorCode)
                .errorList(errorList)
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

}
