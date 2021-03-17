package com.mi.learn.springcloud.base.except;

import lombok.Data;


@Data
public class AbstractException extends RuntimeException {

    private String code = "0001";

    public AbstractException() {
        super();
    }

    public AbstractException(String message) {
        super(message);
    }

    public AbstractException(String code, String message) {
        super(message);
        this.code = code;
    }

    public AbstractException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public AbstractException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractException(Throwable cause) {
        super(cause);
    }

    protected AbstractException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
