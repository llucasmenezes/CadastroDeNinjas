package dev.java10x.CadastroDeNinjas.exceptions;

import dev.java10x.CadastroDeNinjas.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(IdExistsException.class)
    public ResponseEntity<ErrorResponse> handleIdExistsException(IdExistsException e){
       ErrorResponse errorResponse = new ErrorResponse();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoExistIdException.class)
    public ResponseEntity<ErrorResponse> handleNoIdException(NoExistIdException e){
        ErrorResponse errorResponse = new ErrorResponse();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}

