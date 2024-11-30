package com.cengizhanozeyranoglu.exception;

public class BaseException extends RuntimeException {

    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.preapereOfMessage());
    }
}
