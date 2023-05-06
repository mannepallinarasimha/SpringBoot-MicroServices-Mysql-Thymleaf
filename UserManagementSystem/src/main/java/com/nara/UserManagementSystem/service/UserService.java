package com.nara.UserManagementSystem.service;

import com.nara.UserManagementSystem.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    public User addUser( User user);

    public List<User> getAllUsers();

    List<User> getAllUsersByAddress(String address);

    ResponseEntity<String> deleteUserById(Integer id);

    ResponseEntity<String> deleteUserByUser(User user);
}
