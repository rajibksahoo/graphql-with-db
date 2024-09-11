package com.mmdt.graphqlapi.services;

import com.mmdt.graphqlapi.entities.User;
import com.mmdt.graphqlapi.helper.ExceptionHelper;
import com.mmdt.graphqlapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //create a user
    public User createUser(User user){
      return userRepository.save(user);
    }
    //get all user
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    //get single user
    public User getUser(UUID userId){
         return userRepository.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }
    //update user
    //delete user
    public boolean deleteUser(UUID userId){
        User user = userRepository.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepository.delete(user);
        return true;
    }
}
