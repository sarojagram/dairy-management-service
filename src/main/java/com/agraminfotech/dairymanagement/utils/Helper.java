package com.agraminfotech.dairymanagement.utils;

import com.agraminfotech.dairymanagement.security.SecurityService;
import com.agraminfotech.dairymanagement.security.user.User;
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


}
