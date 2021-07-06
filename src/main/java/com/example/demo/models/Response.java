package com.example.demo.models;

public class Response {

    private int code;
    private String message;
    private Object response;

    public Response() {
        code = 200;
        message = "success: Done!";
    }

    public Response(int code, String message, Object response,int size) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

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

    public Object getResponse() {
        return response;
    }

    public Response setResponse(Object response) {
        this.response = response;
        return this;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", response=" + response +
                '}';
    }
}