package com.example.springbootexception.error;

import java.io.Serializable;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/27
 */
public class BaseRs<T> implements Serializable {

    private int code;

    private String message;

    public BaseRs() {
    }

    /**
     * 返回内容
     */
    private T content;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getContent() {
        return content;
    }

    public BaseRs(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseRs(int code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public BaseRs(StatusCodeEnum status) {
        this.code = status.getCode();
        this.message = status.getMsg();
    }

    public BaseRs(StatusCodeEnum status, T content) {
        this.code = status.getCode();
        this.message = status.getMsg();
        this.content = content;
    }

    public static <V> BaseRs ok(V content) {
        return new BaseRs(StatusCodeEnum.SUCCESS, content);
    }

    public static BaseRs ok() {
        return new BaseRs(StatusCodeEnum.SUCCESS);
    }

    public static BaseRs error(StatusCodeEnum error) {
        return new BaseRs(error);
    }

    public void setCode(StatusCodeEnum status) {
        this.code = status.getCode();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BaseRs{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }

    public void setCode(int code) {
        this.code = code;
    }
}