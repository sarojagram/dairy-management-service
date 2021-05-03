package com.agraminfotech.dairymanagement.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    String message;
    Integer statusCode;
    Object body;

    public Response(Object body,String message,Integer statusCode){
        this.body = body;
        this.message = message;
        this.statusCode = statusCode;
    }
}
