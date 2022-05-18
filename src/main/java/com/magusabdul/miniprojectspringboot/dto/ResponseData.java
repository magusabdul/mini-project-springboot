package com.magusabdul.miniprojectspringboot.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseData<T> {
    
    private boolean status;
    private List<String> message = new ArrayList<>();
    private T payload;
    public ResponseData() {
    }
    public ResponseData(boolean status, List<String> message, T payload) {
        this.status = status;
        this.message = message;
        this.payload = payload;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public List<String> getMessage() {
        return message;
    }
    public void setMessage(List<String> message) {
        this.message = message;
    }
    public T getPayload() {
        return payload;
    }
    public void setPayload(T payload) {
        this.payload = payload;
    }
    
}
