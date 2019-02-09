package com.coder.enhance.exception;

/**
 * @author jeffy
 * @date 2019-01-31
 **/
public class AutoCoderException extends RuntimeException {

    private static final int PARAM_ERROR = 400;

    private static final int INNER_ERROR = 500;

    private int code;

    private String message;


    public static AutoCoderException paramException(String message) {
        return new AutoCoderException(PARAM_ERROR, message);
    }

    public static AutoCoderException innerException(String message) {
        return new AutoCoderException(INNER_ERROR, message);
    }

    public AutoCoderException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public AutoCoderException(String message, int code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public AutoCoderException(String message, Throwable cause, int code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public AutoCoderException(Throwable cause, int code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public AutoCoderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
