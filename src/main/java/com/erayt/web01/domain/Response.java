package com.erayt.web01.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

/**
 * @Auther: Z151
 * @Date: 2021/8/12 14:27
 */

//任何未绑定到此类型的属性都应被忽略。
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

    private int code;
    private String message;
    private T response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Response{" +
            "code=" + code +
            ", message='" + message + '\'' +
            ", response=" + response +
            '}';
    }
}
