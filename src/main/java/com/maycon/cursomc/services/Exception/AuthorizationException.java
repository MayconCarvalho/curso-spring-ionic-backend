package com.maycon.cursomc.services.Exception;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException(String msg) {
        super(msg);
    }

    public AuthorizationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
