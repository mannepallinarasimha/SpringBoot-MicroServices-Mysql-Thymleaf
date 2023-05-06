package com.narasimha.taskmanagementsystem.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.narasimha.taskmanagementsystem.exception.ApiException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenProvider {

	// create token
	public String generateToken(Authentication authentication) {
		String email = authentication.getName();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime() + 360000);// milliseconds
		String token = Jwts.builder().setSubject(email).setIssuedAt(currentDate).setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, "JWTSecretKey").compact();
		return token;
	}

	// get email from token
	public String getEmailFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey("JWTSecretKey").parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
	
	//validate token 
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey("JWTSecretKey").parseClaimsJws(token);
			return true;
		}catch(Exception ex) {
			throw new ApiException("Token Issue "+ex.getMessage());
		}
		
	}
}
