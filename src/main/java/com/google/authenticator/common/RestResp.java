package com.google.authenticator.common;

/**
 * @Author: Gaoyp
 * @Description:
 * @Date: Create in 下午2:35 2018/2/28
 * @Modified By:
 */
public class RestResp<T> {

    private int status;
    private String message;
    private T data;

    public RestResp() {
    }

    public RestResp(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
