package com.rajib.graphql.graphql_with_db.services;

import com.rajib.graphql.graphql_with_db.entities.User;
import com.rajib.graphql.graphql_with_db.helper.ExceptionHelper;
import com.rajib.graphql.graphql_with_db.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    //create a user
    public User createUser(User user){
      return userRepo.save(user);
    }
    //get all user
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    //get single user
    public User getUser(int userId){
         return userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }
    //update user
    //delete user
    public boolean deleteUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }
}
