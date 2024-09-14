package com.mmdt.graphqlapi.services;

import com.mmdt.graphqlapi.entities.User;
import com.mmdt.graphqlapi.helper.ExceptionHelper;
import com.mmdt.graphqlapi.mapper.graphql.InputMapper;
import com.mmdt.graphqlapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;



@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final InputMapper inputMapper;

    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() ->ExceptionHelper.throwResourceNotFoundException("User",id.toString()));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->ExceptionHelper.throwResourceNotFoundException("User",email));
    }

    public User getUserByPhoneNo(String phoneNo) {
        return userRepository.findByPhoneNo(phoneNo)
                .orElseThrow(() ->ExceptionHelper.throwResourceNotFoundException("User",phoneNo));
    }

    public User createUser(User input) {
        return userRepository.save(input);
    }

    public User updateUser(UUID id, User input) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->ExceptionHelper.throwResourceNotFoundException("User",id.toString()));
        User updatedUser = inputMapper.userToUser(input);
        updatedUser.setId(existingUser.getId());
        updatedUser.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(updatedUser);
    }

    public boolean deleteUser(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->ExceptionHelper.throwResourceNotFoundException("User",id.toString()));
        userRepository.delete(user);
        return true;
    }
}

