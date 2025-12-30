package com.app.hangerhub.common.exception;


// ? user action with wrong role to action
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
