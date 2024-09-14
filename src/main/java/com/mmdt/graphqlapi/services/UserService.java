package com.mmdt.graphqlapi.services;

import com.mmdt.graphqlapi.entities.User;
import com.mmdt.graphqlapi.exceptions.ResourceNotFoundException;
import com.mmdt.graphqlapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));
    }

    public User getUserByPhoneNo(String phoneNo) {
        return userRepository.findByPhoneNo(phoneNo)
                .orElseThrow(() -> new ResourceNotFoundException("User with phone number " + phoneNo + " not found"));
    }

    public User createUser(User input) {
        return userRepository.save(input);
    }

    public User updateUser(UUID id, User input) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));
        if (input.getFirstName() != null) user.setFirstName(input.getFirstName());
        if (input.getLastName() != null) user.setLastName(input.getLastName());
        if (input.getEmail() != null) user.setEmail(input.getEmail());
        if (input.getPassword() != null) user.setPassword(input.getPassword());
        if (input.getPhoneNo() != null) user.setPhoneNo(input.getPhoneNo());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public boolean deleteUser(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));
        userRepository.delete(user);
        return true;
    }
}

