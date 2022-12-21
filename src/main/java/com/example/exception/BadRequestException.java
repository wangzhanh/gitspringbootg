package com.example.exception;

/**
 * @author
 */
public class BadRequestException extends Exception {
    public BadRequestException(String msg){
        super(msg);
    }
}
