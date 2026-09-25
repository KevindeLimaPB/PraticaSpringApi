package com.sistema.mercadoOnline.Handler;

import com.sistema.mercadoOnline.Exception.ErrorResponse;
import com.sistema.mercadoOnline.Exception.LoginDuplicadoException;
import com.sistema.mercadoOnline.Exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {
//VAI RETORNA UM 409
    @ExceptionHandler(LoginDuplicadoException.class)
    public ResponseEntity<ErrorResponse> HandlerExceptionLoginDuplic(LoginDuplicadoException ex){
        ErrorResponse error = ErrorResponse.builder()
                .response(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
//404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> HandlerNotFoundException(NotFoundException ex){
        ErrorResponse error = ErrorResponse.builder()
                .response(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
