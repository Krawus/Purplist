package com.kramar.purplist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kramar.purplist.entity.Purplist;
import com.kramar.purplist.entity.User;
import com.kramar.purplist.repository.UserRepository;

@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepo){
        this.userRepository = userRepo;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Did not find employee id - " + id));
    }

    public User save(User userToSave){
        return userRepository.save(userToSave);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);;
    }
    
    public User update(User userDetails, int id){

    return userRepository.findById(id)
           .map(user -> {
                user.setUsername(userDetails.getUsername());
                user.setPassword(userDetails.getPassword());
                user.setEnabled(userDetails.isEnabled());
                user.setPurplists(userDetails.getPurplists());
                return userRepository.save(userDetails);
           }).orElseGet(() -> {
            userDetails.setId(id);
            return userRepository.save(userDetails);
           });
        
    }
}
