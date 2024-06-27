package com.matiox.banking_service.config;


import com.matiox.banking_service.exception.BadRequestException;
import com.matiox.banking_service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.hibernate.ResourceClosedException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@RestControllerAdvice //Devuelve el error en formato Json
@AllArgsConstructor
public class RestExceptionHandler {

    private MessageSource messageSource;
    @ExceptionHandler(MethodArgumentNotValidException.class) //Indicar cuál es la excepción
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
            ProblemDetail problemDetail
                    = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "La solicitud tiene unos errores");

            Set<String> errors = new HashSet<>();
            List<FieldError> fieldErrorList = ex.getFieldErrors();

            for (FieldError fe : fieldErrorList) {
                String message = messageSource.getMessage(fe, Locale.getDefault());
                errors.add(message);
            }

            problemDetail.setProperty("errors", errors);

            return problemDetail;

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                "El recurso no ha sido encontrado");
    }

    @ExceptionHandler(BadRequestException.class)
    public ProblemDetail handleBadRequestException (BadRequestException ex){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                ex.getMessage());

    }


}
