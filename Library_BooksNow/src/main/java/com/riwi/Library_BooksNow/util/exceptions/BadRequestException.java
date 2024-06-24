package com.riwi.Library_BooksNow.util.exceptions;

public class BadRequestException extends RuntimeException{
    
    public BadRequestException(String message){
        super(message);
    }
}