package com.narasimha.taskmanagementsystem.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	@Autowired
	private CustomerDetailsService customerDetailsService;

	@Autowired
	private JWTTokenProvider jwtTokenProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// get token from header
		String token = getToken(request);
		// check the token either valid or NOT
		if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {
			String email = jwtTokenProvider.getEmailFromToken(token);
			// if valid we will load user and set authentication
			UserDetails loadUserByUsernameUserDetails = customerDetailsService.loadUserByUsername(email);
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					loadUserByUsernameUserDetails, null, loadUserByUsernameUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
		filterChain.doFilter(request, response);
	}

	private String getToken(HttpServletRequest httpServletRequest) {
		String token = httpServletRequest.getHeader("Autherization");
		// check text token is there or not
		if (StringUtils.hasText(token) && token.startsWith("Bearer")) {
			return token.substring(7, token.length());
		}
		return null;
	}

}
