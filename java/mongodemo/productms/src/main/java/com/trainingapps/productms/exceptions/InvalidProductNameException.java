package com.trainingapps.productms.exceptions;

public class InvalidProductNameException extends RuntimeException{
    public InvalidProductNameException(String msg) {
        super(msg);
    }
}
