package com.kramar.purplist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kramar.purplist.repository.PurplistReository;

@RestController
public class DemoController {

    private PurplistReository purplistRepository;

    public DemoController(PurplistReository purplistReository){
        this.purplistRepository = purplistReository;
    }

    @GetMapping("/")
    public String welcomeString(){
        return "Hello there";
    }
    
}
