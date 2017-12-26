package com.gandazhi.security.common;

/**
 * @author gandazhi
 * @create 2017-12-24 下午2:24
 **/
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
