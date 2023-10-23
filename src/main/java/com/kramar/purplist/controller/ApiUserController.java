package com.kramar.purplist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kramar.purplist.entity.User;
import com.kramar.purplist.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiUserController {

    private UserService userService;

    @Autowired
    public ApiUserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){

        return userService.findById(userId);
    }
    
    @PostMapping("/users")
    public User postUser(@RequestBody User newUser){
        return userService.save(newUser);

    }

    @PutMapping("/users/{userId}")
    public User putUser(@RequestBody User userDetails, @PathVariable int userId){
        return userService.update(userDetails, userId);
    }

    @DeleteMapping("/users/{userId}")
    void deleteList(@PathVariable int userId){
        userService.deleteById(userId);
    }
    
}
