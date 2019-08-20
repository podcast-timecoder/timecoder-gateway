package com.example.timecoder.gateway.exception;

public class FeignProxyException extends Exception {

    public FeignProxyException() {
        super();
    }

    public FeignProxyException(String message) {
        super(message);
    }

    public FeignProxyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeignProxyException(Throwable cause) {
        super(cause);
    }

    protected FeignProxyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
