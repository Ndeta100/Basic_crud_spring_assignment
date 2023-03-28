package com.ndeta.restapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends  RuntimeException {


    private static final Long serialVersionUID=1L;
    public ResourceNotFoundException(String message){
        super(message);
    }
    public ResourceNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

}
