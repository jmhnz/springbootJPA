package com.springbootpractice.jpa.exception;

public class ErrResp {

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrResp(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrResp{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
