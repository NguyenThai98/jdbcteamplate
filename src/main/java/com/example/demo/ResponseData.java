package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Date: 5/11/2023<br/>
 * Time: 9:29 PM<br/>
 */
public class ResponseData<T> {
    @Override
    public String toString() {
        return "ResponseData [status=" + status + ", data=" + data + "]";
    }

    private int status;
    private T data = null;

    public ResponseData() {
    }

    private ResponseData(int status, T data) {
        setStatus(status);
        setData(data);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Success Data
     *
     * @param object
     * @return
     */
    public static <T> ResponseData<T> getSuccessData(T object) {
        return new ResponseData<T>(HttpStatus.OK.value(), object);
    }


}
