package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class SuccessResponse<T> extends Response {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private T data;

    public SuccessResponse() {
        super.setCode("Success");
        super.setStatus(HttpStatus.OK.value());
        super.setMessage("The api request was successful.");
    }

    public SuccessResponse(T data) {
        this();
        this.data = data;
    }

    static public SuccessResponse create() { return new SuccessResponse();}

    public SuccessResponse code(String code){
        super.setCode(code);
        return this;
    }

    public SuccessResponse status(int status) {
        super.setStatus(status);
        return this;
    }

    public SuccessResponse message(String message) {
        super.setMessage(message);
        return this;
    }

    public SuccessResponse data(T data){
        this.data = data;
        return this;
    }
}
