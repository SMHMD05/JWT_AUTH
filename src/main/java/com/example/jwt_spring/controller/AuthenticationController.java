package com.example.jwt_spring.controller;

import com.example.jwt_spring.model.AuthenticationResponse;
import com.example.jwt_spring.model.User;
import com.example.jwt_spring.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthenticationController {
private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>register(
            @RequestBody User request
            ){
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>login(
            @RequestBody User request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
