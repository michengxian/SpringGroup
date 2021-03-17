package com.mi.learn.springcloud.base.except;

public class DefaultException extends AbstractException {

    public DefaultException() {
        super();
    }

    public DefaultException(String message) {
        super(message);
    }

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultException(Throwable cause) {
        super(cause);
    }

    protected DefaultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
