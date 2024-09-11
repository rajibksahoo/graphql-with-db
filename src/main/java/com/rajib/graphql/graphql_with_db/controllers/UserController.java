package com.rajib.graphql.graphql_with_db.controllers;


import com.rajib.graphql.graphql_with_db.entities.User;
import com.rajib.graphql.graphql_with_db.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create order api
    @MutationMapping
    public User createUser(@Argument String name,@Argument String phone,@Argument String email,@Argument String password){
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }

    //get users
    @QueryMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //get Single User
    @QueryMapping
    public User getUser(@Argument int userId){
        return userService.getUser(userId);
    }

    //delete User
    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }
}
