package com.riwi.Library_BooksNow.api.error_handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.Library_BooksNow.api.dto.errors.BaseErrorResponse;
import com.riwi.Library_BooksNow.api.dto.errors.ErrorResponse;
import com.riwi.Library_BooksNow.util.exceptions.BadRequestException;

@RestControllerAdvice //observador de la app que controla los errores
@ResponseStatus(code = HttpStatus.BAD_REQUEST) //codigo 400 que advierte que no se envian los parametros como se piden
public class BadRequestController {
    public BaseErrorResponse handleBadRequest(MethodArgumentNotValidException exception){    //manejo de errores del request y retorna un codigo y estado de error

        List<Map<String, String>> errors = new ArrayList<>(); //creacion de una lista para mapear los errores

        exception.getBindingResult().getFieldErrors().forEach(
            e->{    //se itera cada elemento de la coleccion de errores
                Map<String,String> error = new HashMap<>();    //se genera un mapeo

                error.put("error", e.getDefaultMessage());  //se agrega el error al map
                error.put("field", e.getField());   //agrega al map en donde ocurrio el error

                errors.add(error);
            }
        );
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())   //devuelve el valor numerico del error
                .status(HttpStatus.BAD_REQUEST.name())  //devuelve el string del stado
                .errors(errors)
                .build();
    }

    /* Manejo de errores 404 de cuando no se encuentra la entidad solicitada */
    @ExceptionHandler(BadRequestException.class)
    public BaseErrorResponse handleError(BadRequestException exception){
        List<Map<String,String>> errors = new ArrayList<>();

        Map<String,String> error = new HashMap<>();
        
        error.put("id", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value()) // 404
                .status(HttpStatus.NOT_FOUND.name()) // NOT_FOUND
                .errors(errors) // [ { "field": "mal", "error": "mal"} ]
                .build();
    }


}
