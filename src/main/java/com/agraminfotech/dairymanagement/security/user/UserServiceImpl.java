package com.agraminfotech.dairymanagement.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private UserService userService;

    @Autowired
    private UserServiceImpl(UserService userService){
        this.userService = userService;
    }
}
