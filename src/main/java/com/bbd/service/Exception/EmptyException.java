package com.bbd.service.Exception;

public class EmptyException extends Exception {
    private String message;

    public EmptyException() {
        super();
    }
    public EmptyException(String message) {
        super();
        this.message = message;
    }
    public String getMsg() {
        return message;
    }
    public void setMsg(String message) {
        this.message = message;
    }
}
