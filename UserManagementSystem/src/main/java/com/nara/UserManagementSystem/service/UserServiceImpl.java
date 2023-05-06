package com.nara.UserManagementSystem.service;

import com.nara.UserManagementSystem.model.User;
import com.nara.UserManagementSystem.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("Users From DB ********"+users);
        //log.info("Users From DB ::::",users);
        return users;
    }

    @Override
    public List<User> getAllUsersByAddress( String address) {
        System.out.println("All Addresses***"+userRepository.findByAddress(address));
        return userRepository.findByAddress(address);
    }

    @Override
    public ResponseEntity<String> deleteUserById(Integer id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>("User with ID Deleted Successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteUserByUser(User user) {
        userRepository.delete(user);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }
}
