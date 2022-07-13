package com.oscar.nicholas.handler;

import com.oscar.nicholas.exception.InvalidRequestException;
import com.oscar.nicholas.exception.NotFoundException;
import com.oscar.nicholas.resource.ErrorResource;
import com.oscar.nicholas.resource.FieldResource;
import com.oscar.nicholas.resource.InvalidErrorResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handleNotFound(RuntimeException e) {
        ErrorResource errorResource = new ErrorResource(e.getMessage());
        ResponseEntity result = new ResponseEntity<>(errorResource, HttpStatus.NOT_FOUND);
        log.warn(" result -------- {}", result);
        return result;
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseBody
    public ResponseEntity<?> handleInvalidRequest(InvalidRequestException e) {
        Errors errors = e.getErrors();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        List<FieldResource> fieldResources = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            FieldResource fieldResource = new FieldResource(fieldError.getObjectName(), fieldError.getField(), fieldError.getCode(), fieldError.getDefaultMessage());
            fieldResources.add(fieldResource);
        }
        InvalidErrorResource invalidErrorResource = new InvalidErrorResource(e.getMessage(), fieldResources);

        ResponseEntity result = new ResponseEntity<>(invalidErrorResource, HttpStatus.BAD_REQUEST);
        log.warn(" result -------- {}", result);
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleException(Exception exception) {
        log.error("Error ------- {}",exception.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
