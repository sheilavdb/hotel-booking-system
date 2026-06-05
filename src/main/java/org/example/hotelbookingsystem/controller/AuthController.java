package org.example.hotelbookingsystem.controller;

import org.example.hotelbookingsystem.model.LoginRequest;
import org.example.hotelbookingsystem.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthController {

    private AuthenticationManager authManager;
    private JwtService jwtService;
    private UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authManager, JwtService jwtService, UserDetailsService userDetailsService ) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));

            UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
            String role = userDetails.getAuthorities().iterator().next().getAuthority();

            String token = jwtService.generateToken(req.getUsername(), role);
            return ResponseEntity.ok(Map.of("token", token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}