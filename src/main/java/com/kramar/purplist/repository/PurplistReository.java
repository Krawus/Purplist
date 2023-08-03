package com.kramar.purplist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kramar.purplist.entity.Purplist;

public interface PurplistReository extends JpaRepository<Purplist, Integer>{
    
}
