package com.kramar.purplist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kramar.purplist.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    Optional<User> findByUsername(String username);

    
}
