package com.ahmad.projects.voting_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Handler for ResourceNotFoundException
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    //Handler for DuplicateResourceException
    @ExceptionHandler(value = DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handlerDuplicateResourceException(DuplicateResourceException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

    //Handler for VoteNotAllowedException
    @ExceptionHandler(value = VoteNotAllowedException.class)
    public ResponseEntity<ErrorResponse> handlerVoteNotAllowedException(VoteNotAllowedException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(), HttpStatus.FORBIDDEN.value());
        return new ResponseEntity<>(errorResponse,HttpStatus.FORBIDDEN);
    }


    //Handler for Validation error
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> errors=new HashMap<>();
        BindingResult bindingResult =ex.getBindingResult();
        List<FieldError> fieldErrors=bindingResult.getFieldErrors();

        for (FieldError error:fieldErrors){
            errors.put(error.getField(),error.getDefaultMessage());
        }

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }


    //Handler for  Generalized Exception
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handlerGeneralException(Exception ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
