package com.kramar.purplist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kramar.purplist.entity.Purplist;
import com.kramar.purplist.entity.User;
import com.kramar.purplist.repository.UserRepository;
import com.kramar.purplist.service.PurplistService;
import com.kramar.purplist.service.UserService;

@RestController
public class DemoController {

    private UserService userService;
    private PurplistService purplistService;

    @Autowired
    public DemoController(UserService userServ, PurplistService purplistServ){
        this.userService = userServ;
        this.purplistService = purplistServ;
    }
    
    @GetMapping("/")
    public String showHomePage(){
        return "Hello there";
    }

}
