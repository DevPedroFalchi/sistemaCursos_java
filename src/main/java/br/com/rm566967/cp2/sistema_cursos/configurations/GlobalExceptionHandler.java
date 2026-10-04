package br.com.rm566967.cp2.sistema_cursos.configurations;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<ErrorCustomResponse> handleException(ConfigDataResourceNotFoundException ex){
        return build.(HttpStatus.NOT_FOUND, ex.getMessage());
    }

}