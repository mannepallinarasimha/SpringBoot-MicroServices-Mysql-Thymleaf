package com.narasimha.taskmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narasimha.taskmanagementsystem.payload.JWTAuthResponse;
import com.narasimha.taskmanagementsystem.payload.LoginDto;
import com.narasimha.taskmanagementsystem.payload.UsersDto;
import com.narasimha.taskmanagementsystem.security.JWTTokenProvider;
import com.narasimha.taskmanagementsystem.service.UsersService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTTokenProvider jwtTokenProvider;
	
	//POST using store user
	@PostMapping("/register")
	public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto) {
		return new ResponseEntity<>(usersService.createUser(usersDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponse> loginUser(@RequestBody LoginDto loginDto){
		Authentication authenticate = 
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		//get the token using class name JwttOKEN PROVIDER AND Autowire it 
		String token = jwtTokenProvider.generateToken(authenticate);
		
		return ResponseEntity.ok(new JWTAuthResponse(token));
		
	}

}
