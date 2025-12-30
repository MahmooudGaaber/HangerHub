package com.app.hangerhub.common.exception;


// ? used like when the item out of stock
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
