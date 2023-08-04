package com.kramar.purplist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kramar.purplist.entity.Purplist;
import com.kramar.purplist.repository.PurplistReository;

@Service
public class PurplistService {

    private PurplistReository purplistReository;

    @Autowired
    public PurplistService(PurplistReository purplistReository){
        this.purplistReository = purplistReository;
    }

    public List<Purplist> findAll(){
        return purplistReository.findAll();
    }
    public Purplist findById(int id){

        Optional<Purplist> searchResult = purplistReository.findById(id);
        
        if (searchResult.isPresent()){
            return searchResult.get();
        }
        else{
            throw new RuntimeException("Did not find employee id - " + id);
        }
    }


}
