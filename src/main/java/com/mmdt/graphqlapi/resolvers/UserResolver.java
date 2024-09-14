package com.mmdt.graphqlapi.resolvers;

import com.mmdt.graphqlapi.dtos.UserInput;
import com.mmdt.graphqlapi.entities.User;
import com.mmdt.graphqlapi.mapper.graphql.InputMapper;
import com.mmdt.graphqlapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UserResolver {

    private  final UserService userService;
    private final InputMapper inputMapper;


    @MutationMapping
    public User createUser(@Argument UserInput input) {
        return userService.createUser(inputMapper.toEntity(input));
    }

    @MutationMapping
    public User updateUser(@Argument UUID id, @Argument UserInput input) {
        return userService.updateUser(id, inputMapper.toEntity(input));
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
