package com.nara.UserManagementSystem;

import com.nara.UserManagementSystem.model.User;
import com.nara.UserManagementSystem.repository.UserRepository;
import com.nara.UserManagementSystem.service.UserService;
import com.nara.UserManagementSystem.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagementSystemApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;


//	@Test
//	public void getAllUsersTest(){
//		when(repository.findAll()).thenReturn(Stream.of(
//				new User(1, "nara","nara@gmail.com","hyd"),
//				new User(2, "priya","priya@gmail.com","hyd"),
//				new User(3, "satya","satya@gmail.com","hyd")).collect(Collectors.toList()));
//
//		assertEquals(3, service.getAllUsers().size() );
//	}

	@Test
	public void getAllUserTest(){
		when(repository.findAll()).thenReturn(Stream.of(
				new User(1, "nara","nara@gmail.com","hyd"),
				new User(2, "priya","priya@gmail.com","hyd")
		).collect(Collectors.toList()));
		assertEquals(2, service.getAllUsers().size());
	}

	@Test
	public void findUsersByAddressTest(){
		String address = "hyd";
		when(repository.findByAddress(address)).thenReturn(Stream.of(
				new User(1, "nara","nara@gmail.com","hyd"),
				new User(2, "priya","priya@gmail.com","chennai")
		).collect(Collectors.toList()));
		assertEquals(2, service.getAllUsersByAddress(address).size());
	}

	@Test
	public void saveUserTest(){
		User user = new User(1, "nara","nara@gmail.com","hyd");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}

	@Test
	public void deleteUserById(){
		Integer id = 1;
		service.deleteUserById(id);
		verify(repository, times(1)).deleteById(id);
	}

	@Test
	public void deleteUserTest(){
		User user = new User(1, "nara","nara@gmail.com","hyd");
		service.deleteUserByUser(user);
		verify(repository, times(1)).delete(user);
	}

}
