package com.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.models.RegisterRequest;
import com.blog.security.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
    //@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
    	authService.signup(registerRequest);
    	return new ResponseEntity(HttpStatus.OK);
    	
    }
    

}
