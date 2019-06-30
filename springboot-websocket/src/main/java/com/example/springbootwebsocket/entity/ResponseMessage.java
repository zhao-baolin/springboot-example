package com.example.springbootwebsocket.entity;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/30
 */
public class ResponseMessage {
    private String content;

    public ResponseMessage() {
    }

    public ResponseMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "content='" + content + '\'' +
                '}';
    }
}
