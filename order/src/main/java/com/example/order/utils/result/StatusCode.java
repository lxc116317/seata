package com.example.order.utils.result;

import java.io.Serializable;

/**
 * 统一状态码
 * 使用4位数字
 */
public enum StatusCode implements Serializable {
    
    /**
     * 请求成功
     */
    RET_SUCCESS(0, "成功"),

    RET_ERROR(1,"错误"),

    RET_CODE_NOT_FOUND(5303,"验证码失效");


    public int code;
    public String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
