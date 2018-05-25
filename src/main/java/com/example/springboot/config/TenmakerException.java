package com.example.springboot.config;

public class TenmakerException extends Exception {
    private int code;

    public TenmakerException(String message) {
        super(message);
        this.code = -1;
    }

    public TenmakerException(ReturnDataEnum returnDataEnum) {
        super(returnDataEnum.msg);
        this.code = returnDataEnum.code;
    }

    public int getCode() {
        return this.code;
    }
}
