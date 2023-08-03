package com.kramar.purplist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kramar.purplist.entity.Purplist;
import com.kramar.purplist.repository.PurplistReository;

@RestController
public class DemoController {

    private PurplistReository purplistRepository;

    @Autowired
    public DemoController(PurplistReository purplistReository){
        this.purplistRepository = purplistReository;
    }

    @GetMapping("/")
    public String welcomeString(){
        return "Hello there";
    }

    @GetMapping("/lists")
    public List<Purplist> getAllPurplists(){
        return purplistRepository.findAll();
    }
    
}
