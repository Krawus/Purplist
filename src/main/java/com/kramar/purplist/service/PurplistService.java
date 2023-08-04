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

        return purplistReository.findById(id)
                .orElseThrow(() -> new RuntimeException("Did not find employee id - " + id));
    }

    public Purplist save(Purplist purplist){
        return purplistReository.save(purplist);
    }

    public Purplist update(Purplist purplistDetails, int id){

        return purplistReository.findById(id)
        .map(purplist -> {
          purplist.setName(purplistDetails.getName());
          purplist.setContent(purplistDetails.getContent());
          return purplistReository.save(purplist);
        })
        .orElseGet(() -> {
          purplistDetails.setId(id);
          return purplistReository.save(purplistDetails);
        });


        // Purplist purplistToUpdate = findById(id);

        // purplistToUpdate.setContent(purplistDetails.getContent());
        // purplistToUpdate.setName(purplistDetails.getName());

        // return purplistReository.save(purplistToUpdate);
        
    }

    public void deleteById(int id){
        purplistReository.deleteById(id);
    }



}


