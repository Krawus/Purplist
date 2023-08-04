package com.kramar.purplist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kramar.purplist.entity.Purplist;
import com.kramar.purplist.service.PurplistService;

@RestController
@RequestMapping("/api")
public class DemoController {

    private PurplistService purplistService;

    @Autowired
    public DemoController(PurplistService purplistService){
        this.purplistService = purplistService;
    }

    @GetMapping("/lists")
    public List<Purplist> getAllPurplists(){
        return purplistService.findAll();
    }

    @GetMapping("/lists/{purplistId}")
    public Purplist getPurplist(@PathVariable int purplistId){

        return purplistService.findById(purplistId);
    }

    @GetMapping("/test")
    public Purplist testPurp(){
        return purplistService.findById(9);
    }
    
}
