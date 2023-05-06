package com.narasimha.taskmanagementsystem.payload;

import lombok.Data;

@Data
public class JWTAuthResponse {

	private String token;
	private String tokeType = "Bearer";
	
	public JWTAuthResponse(String token) {
		super();
		this.token = token;
	}
	
	
}
