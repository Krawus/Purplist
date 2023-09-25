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
import com.kramar.purplist.entity.Purplist;
import com.kramar.purplist.service.PurplistService;

@RestController
@RequestMapping("/api")
public class ApiListController {

    private PurplistService purplistService;

    @Autowired
    public ApiListController(PurplistService purplistService){
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

    @PostMapping("/lists")
    public Purplist postPurplist(@RequestBody Purplist newPurplist){
        return purplistService.save(newPurplist);

    }

    @PutMapping("/lists/{purplistId}")
    public Purplist putPurplist(@RequestBody Purplist purplistDetails, @PathVariable int purplistId){
        return purplistService.update(purplistDetails, purplistId);
    }

    @DeleteMapping("/lists/{purplistId}")
    void deleteList(@PathVariable int purplistId){
        purplistService.deleteById(purplistId);
    }
    
}
