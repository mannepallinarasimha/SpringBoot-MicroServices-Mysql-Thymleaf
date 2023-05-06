package com.narasimha.taskmanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.narasimha.taskmanagementsystem.entity.Users;
import com.narasimha.taskmanagementsystem.exception.UsersNotFoundException;
import com.narasimha.taskmanagementsystem.payload.UsersDto;
import com.narasimha.taskmanagementsystem.repository.UsersRepository;
import com.narasimha.taskmanagementsystem.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsersRepository usersRepository; 
	@Override
	public UsersDto createUser(UsersDto usersDto) {
		// TODO Auto-generated method stub
		//before storing the password into DB we are encrypting password and storing in DB 
		usersDto.setPassword(passwordEncoder.encode(usersDto.getPassword()));
		Users users = usersDtoToEntity(usersDto);
		Users savedUser = usersRepository.save(users);
		return entityToUsersDto(savedUser);
	}

	private Users usersDtoToEntity(UsersDto usersDto) {
		Users users = new Users();
		users.setName(usersDto.getName());
		users.setEmail(usersDto.getEmail());
		users.setPassword(usersDto.getPassword());
		return users;
	}
	
	private UsersDto entityToUsersDto(Users savedUser) {
		UsersDto usersDto = new UsersDto();
		usersDto.setId(savedUser.getId());
		usersDto.setName(savedUser.getName());
		usersDto.setEmail(savedUser.getEmail());
		usersDto.setPassword(savedUser.getPassword());
		return usersDto;
	}
}
