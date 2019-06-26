package com.example.springbootexception.error;

import java.io.Serializable;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/27
 */
public enum StatusCodeEnum implements Serializable {
    SUCCESS(0, "成功"),
    ERROR(-1, "失败"),
    USER_INVALID(60000, "无效用户"),
    SYS_ARG_INVALID(11000, "无效参数"),

    ;
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;

    StatusCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //根据code获取对应枚举
    public static StatusCodeEnum getByCode(int code) {
        StatusCodeEnum[] values = StatusCodeEnum.values();

        for (StatusCodeEnum bizStatusCodeEnum : values) {
            if (bizStatusCodeEnum.code == code) {
                return bizStatusCodeEnum;
            }
        }
        return null;
    }
}
