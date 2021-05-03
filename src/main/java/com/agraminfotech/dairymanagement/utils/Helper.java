package com.agraminfotech.dairymanagement.utils;

import com.agraminfotech.dairymanagement.security.SecurityService;
import com.agraminfotech.dairymanagement.security.user.User;
import com.agraminfotech.dairymanagement.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class Helper {

    private final SecurityService securityService;

    private Helper(SecurityService securityService){
        this.securityService = securityService;
    }

    public User getCurrentUser(){
        return  securityService.getCurrentUser();
    }

    public static ResponseEntity<Response> getResponseEntity(Object body, String message, Integer statusCode){
        return new ResponseEntity<>(new Response(body, message, statusCode), HttpStatus.OK);
    }


}
