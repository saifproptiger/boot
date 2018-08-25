package com.saif.demo.exception;

import com.saif.demo.pojo.StatusCode;

public class BadRequestException extends ApiException {

    private static final long serialVersionUID = 9182027485694092915L;

    private String            message;

    private Throwable         cause;

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message, Throwable cause) {
        super(StatusCode.BAD_REQUEST, message, cause);
        this.message = message;
        this.cause = cause;
    }

    public BadRequestException(String message) {
        super(StatusCode.BAD_REQUEST, message);
        this.message = message;
    }

    public BadRequestException(Throwable cause) {
        super(StatusCode.BAD_REQUEST, cause);
        this.cause = cause;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

}
