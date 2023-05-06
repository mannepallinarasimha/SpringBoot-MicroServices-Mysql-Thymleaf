package com.narasimha.taskmanagementsystem.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.narasimha.taskmanagementsystem.entity.Users;
import com.narasimha.taskmanagementsystem.exception.UsersNotFoundException;
import com.narasimha.taskmanagementsystem.repository.UsersRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users users = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsersNotFoundException(String.format("User NOT Found with Email ID: %s", email)));
		Set<String> roles = new HashSet<>();
		roles.add("ROLE_ADMIN");
		return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(), userAuthorities(roles));
	}
	
	private Collection<? extends GrantedAuthority> userAuthorities(Set<String> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	}

}
