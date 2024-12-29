package com.kramar.purplist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kramar.purplist.entity.Invitation;
import com.kramar.purplist.repository.InvitationRepository;

@Service
public class InvitationService {

    private InvitationRepository invitationRepository;

    public InvitationService(InvitationRepository invitationRepository){
        this.invitationRepository = invitationRepository;
    }

    public void deleteById(int id){
        invitationRepository.deleteById(id);
    }

    public void save(Invitation invitation){
        invitationRepository.save(invitation);
    }

    public Invitation findById(int id){
        return invitationRepository.findById(id).orElseThrow(() -> new RuntimeException("Did not find invitation id - " + id));
    }
}
