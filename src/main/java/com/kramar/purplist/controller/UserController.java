package com.kramar.purplist.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kramar.purplist.entity.Invitation;
import com.kramar.purplist.entity.Purplist;
import com.kramar.purplist.entity.User;
import com.kramar.purplist.service.InvitationService;
import com.kramar.purplist.service.PurplistService;
import com.kramar.purplist.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private PurplistService purplistService;
    private InvitationService invitationService;

    public UserController(UserService thUserService, PurplistService thePurplistService, InvitationService invitationService) {
        this.userService = thUserService;
        this.purplistService = thePurplistService;
        this.invitationService = invitationService;
    }

    @GetMapping("")
    public User getUser(Principal principal){
        User loggedUser = getLoggedUser(principal);

        return loggedUser;
    }

    @GetMapping("/lists")
    public Iterable<Purplist> getUserLists(Principal principal){
        User loggedUser = getLoggedUser(principal);

        return loggedUser.getPurplists();

    }
    
    @GetMapping("/lists/{listIndex}")
    public Purplist getUserList(Principal principal, @PathVariable int listIndex){
        User loggedUser = getLoggedUser(principal);
        List<Purplist> userLists = loggedUser.getPurplists();

        return userLists.get(listIndex);
    }

    @PutMapping("/lists/{listIndex}")
    public Purplist putUserPurplist(@RequestBody Purplist purplistDetails, @PathVariable int listIndex, Principal principal){

        User loggedUser = getLoggedUser(principal);

        Purplist listToUpdate = loggedUser.getPurplists().get(listIndex);
        
        return purplistService.update(purplistDetails, listToUpdate.getId());
    }

    @PostMapping("/lists")
    public Purplist postUserPurplist(@RequestBody Purplist newPurplist, Principal principal){

        User loggedUser = getLoggedUser(principal);
        newPurplist.addUser(loggedUser);

        loggedUser.addPurplist(newPurplist);

        return purplistService.save(newPurplist);

    }

    @DeleteMapping("/lists/{listIndex}")
    void deleteUserPurplist(@PathVariable int listIndex, Principal principal){
        User loggedUser = getLoggedUser(principal);

        Purplist purplistToDelete = loggedUser.getPurplists().get(listIndex);
        
        loggedUser.deletePurplist(listIndex);

        purplistService.deleteById(purplistToDelete.getId());
    }

    
    User getLoggedUser(Principal principal){
        return userService.findByUsername(principal.getName()); 
    }

    @GetMapping("/sent-invitations")
    public Iterable<Invitation> getUserReceivedInvitations(Principal principal) {
        User loggedUser = getLoggedUser(principal);

        return loggedUser.getSentInvitations();
    }

    @GetMapping("/received-invitations")
    public Iterable<Invitation> getUserSentInvitations(Principal principal) {
        User loggedUser = getLoggedUser(principal);
        
        return loggedUser.getReceivedInvitations();
    }

    @PostMapping("/lists/{listIndex}/invitation")
    public void sendInvitationToUser(@PathVariable int listIndex, @RequestParam String receiverUsername, Principal principal) {

        if (receiverUsername.equals(principal.getName())) {
            throw new RuntimeException("You can't send invitation to yourself");
        }

        User loggedUser = getLoggedUser(principal);
        Purplist purplist = loggedUser.getPurplists().get(listIndex);
        
        User receiver = userService.findByUsername(receiverUsername);

        Invitation invitation = new Invitation();
        invitation.setPurplist(purplist);
        invitation.setSender(loggedUser);
        invitation.setReceiver(receiver);
        
        invitationService.save(invitation);
    }

    @PutMapping("/received-invitations/{invitationIndex}/accept")
    public void acceptInvitation(@PathVariable int invitationIndex, Principal principal){
        User loggedUser = getLoggedUser(principal);
        Invitation invitation = loggedUser.getReceivedInvitations().get(invitationIndex);

        invitation.setAccepted(true);
        loggedUser.addPurplist(invitation.getPurplist());
        userService.save(loggedUser);
        invitationService.save(invitation);
    }

    @PutMapping("/received-invitations/{invitationIndex}/decline")
    public void declineInvitation(@PathVariable int invitationIndex, Principal principal){
        User loggedUser = getLoggedUser(principal);
        Invitation invitation = loggedUser.getReceivedInvitations().get(invitationIndex);

        invitation.setAccepted(false);
        invitationService.save(invitation);
    }

    @DeleteMapping("/received-invitations/{invitationIndex}") 
    public void deleteReceivedInvitation(@PathVariable int invitationIndex, Principal principal){
        User loggedUser = getLoggedUser(principal);
        Invitation invitation = loggedUser.getReceivedInvitations().get(invitationIndex);

        invitationService.deleteById(invitation.getId());
    }

    @DeleteMapping("/sent-invitations/{invitationIndex}")
    public void deleteSentInvitation(@PathVariable int invitationIndex, Principal principal){
        User loggedUser = getLoggedUser(principal);
        Invitation invitation = loggedUser.getSentInvitations().get(invitationIndex);

        invitationService.deleteById(invitation.getId());
    }
}
