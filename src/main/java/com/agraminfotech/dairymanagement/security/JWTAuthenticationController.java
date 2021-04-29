package com.agraminfotech.dairymanagement.security;

import com.agraminfotech.dairymanagement.security.user.User;
import com.agraminfotech.dairymanagement.security.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JWTAuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JWTTokenUtils jwtTokenUtils;

    private final UserService userService;

    @Autowired
    private JWTAuthenticationController(AuthenticationManager authenticationManager,JWTTokenUtils jwtTokenUtils,
                                        UserService userService){
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtils = jwtTokenUtils;
        this.userService = userService;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {

        Authentication au =  authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        SecurityContextHolder.getContext().setAuthentication(au);
        final UserDetails userDetails = userService.loadUserByUsername(au.getName());

        final String token = jwtTokenUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JWTResponse(token));
    }


    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
