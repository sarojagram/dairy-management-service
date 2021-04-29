package com.agraminfotech.dairymanagement.security.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

   /* @GetMapping(value= "admin/user/findAll")
    public ResponseEntity<.> findById(Long id){

    }*/
}
