package com.narasimha.taskmanagementsystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

	private Long id;
	private String name;
	private String email;
	private String password;
}
