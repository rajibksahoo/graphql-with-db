package com.mmdt.graphqlapi.resolvers.queries;

import com.mmdt.graphqlapi.entities.User;
import com.mmdt.graphqlapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserResolver {

    @Autowired
    private UserService userService;

    @MutationMapping
    public User createUser(@Argument User input) {
        return userService.createUser(input);
    }

    @MutationMapping
    public User updateUser(@Argument UUID id, @Argument User input) {
        return userService.updateUser(id, input);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument UUID id) {
        return userService.deleteUser(id);
    }

    @QueryMapping
    public User getUser(@Argument UUID id) {
        return userService.getUserById(id);
    }

    @QueryMapping
    public User getUserByEmail(@Argument String email) {
        return userService.getUserByEmail(email);
    }

    @QueryMapping
    public User getUserByPhoneNo(@Argument String phoneNo) {
        return userService.getUserByPhoneNo(phoneNo);
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
