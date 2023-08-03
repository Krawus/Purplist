package com.kramar.purplist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kramar.purplist.entity.Purplist;

@Repository
public interface PurplistReository extends JpaRepository<Purplist, Integer>{
    
}
