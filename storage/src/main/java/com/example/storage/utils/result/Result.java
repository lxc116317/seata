package com.example.storage.utils.result;

import java.io.Serializable;

public class Result<T> implements Serializable {

    public static final Result SUCCESS = new Result();

    private int code;
    private String message;
    private T data;

    public Result() {
        this(null, StatusCode.RET_SUCCESS);
    }

    public Result(String message,int code){
        this.code=code;
        this.message=message;
    }

    public Result(String message,int code,T data){
        this.code=code;
        this.message=message;
        this.data = data;
    }

    public Result(T data) {
        this(data, StatusCode.RET_SUCCESS);
    }

    public Result(StatusCode errorCode) {
        this(null, errorCode);
    }

    public Result(T data, StatusCode statusCode) {
        this.data = data;
        this.code = statusCode.code;
        this.message = statusCode.msg;
    }

    public T getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
