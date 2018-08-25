package com.saif.demo.exception;

import com.saif.demo.pojo.StatusCode;

public class ApiException extends RuntimeException {

    private static final long serialVersionUID = -8659400727561653530L;

    private StatusCode        statusCode       = StatusCode.SERVER_ERROR;

    private String            message;

    private Throwable         cause;

    public ApiException() {
        super();
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }

    public ApiException(String message) {
        super(message);
        this.message = message;
    }

    public ApiException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public ApiException(StatusCode statusCode, String message, Throwable cause) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.cause = cause;
    }

    public ApiException(StatusCode statusCode, Throwable cause) {
        super();
        this.statusCode = statusCode;
        this.cause = cause;
    }

    public ApiException(StatusCode statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
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
