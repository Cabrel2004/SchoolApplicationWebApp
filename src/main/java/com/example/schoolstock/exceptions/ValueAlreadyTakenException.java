package com.example.schoolstock.exceptions;
public class ValueAlreadyTakenException extends Exception{

    public ValueAlreadyTakenException(String entityName,String value) {
        super(entityName+" with value <<"+value+ ">> already taken, use another....");
    }
}

