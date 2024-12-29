package com.kramar.purplist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kramar.purplist.entity.Invitation;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Integer>{
    
}
