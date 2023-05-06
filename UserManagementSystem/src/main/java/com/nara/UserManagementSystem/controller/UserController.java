package com.nara.UserManagementSystem.controller;

import com.nara.UserManagementSystem.model.User;
import com.nara.UserManagementSystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(path="/addUser")
    public User addUser(@RequestBody(required = true) User user){
       return  userService.addUser(user);
    }

    @GetMapping(path="/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path="/getAllUsersByAddress/{address}")
    public List<User> getAllUsersByAddress(@PathVariable("address") String address){
        return userService.getAllUsersByAddress(address);
    }

    @DeleteMapping(path="/deleteUser/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Integer id){
        return userService.deleteUserById(id);
    }

    @DeleteMapping(path="/deleteUser")
    public ResponseEntity<String> deleteUserByUser(@RequestBody User user){
        return userService.deleteUserByUser(user);
    }
}
