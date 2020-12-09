package com.matyspring.market.web.controller;

import com.matyspring.market.domain.dto.AuthenticationRequest;
import com.matyspring.market.domain.dto.AuthenticationResponse;
import com.matyspring.market.domain.service.MatyUserDetailsService;
import com.matyspring.market.web.security.JWTUtil;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MatyUserDetailsService matyUserDetailsService;

    @Autowired
    private JWTUtil jwtUtilL;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationRequest> createToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = matyUserDetailsService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtilL.generateToken(userDetails);
            return new ResponseEntity<>((MultiValueMap<String, String>) new AuthenticationResponse(jwt), HttpStatus.OK);
        }catch(BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
