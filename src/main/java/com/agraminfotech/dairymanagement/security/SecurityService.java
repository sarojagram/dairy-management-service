package com.agraminfotech.dairymanagement.security;

import com.agraminfotech.dairymanagement.security.user.User;
import com.agraminfotech.dairymanagement.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SecurityService {

   private UserRepository userRepository;

   @Autowired
   private SecurityService(UserRepository userRepository){
       this.userRepository = userRepository;
   }

    public User getCurrentUser(){
        Optional<User> userOpt = SecurityUtils.getCurrentUserLogin().flatMap(userRepository::findOneByUsername);
        if(!userOpt.isPresent()) throw new RuntimeException("User does not exists!");
        return userOpt.get();
    }

}
