package com.example.monitor.exception;

public class ConvertQueryWrapperException extends RuntimeException{

    public ConvertQueryWrapperException(String message){
        super(message);
    }

    public ConvertQueryWrapperException(String message,Throwable e){
        super(message,e);
    }

}
