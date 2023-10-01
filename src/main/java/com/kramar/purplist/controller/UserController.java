package com.kramar.purplist.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kramar.purplist.entity.Purplist;
import com.kramar.purplist.entity.User;
import com.kramar.purplist.service.PurplistService;
import com.kramar.purplist.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private PurplistService purplistService;

    @Autowired
    public UserController(UserService thUserService, PurplistService thePurplistService){
        this.userService = thUserService;
        this.purplistService = thePurplistService;
    }

    @GetMapping("")
    public User getUser(Principal principal){
        String loggedUsername = principal.getName();
        User loggedUser = userService.findByUsername(loggedUsername);

        return loggedUser;
    }

    @GetMapping("/lists")
    public Iterable<Purplist> getUserLists(Principal principal){
        String loggedUsername = principal.getName();
        User loggedUser = userService.findByUsername(loggedUsername);

        return loggedUser.getPurplists();

    }

}
