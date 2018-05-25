package com.example.springboot.model;

public class ResponseMessage {
    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public ResponseMessage(String responseMessage){
        this.responseMessage=responseMessage;
    }
}
