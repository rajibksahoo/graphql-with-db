package com.mmdt.graphqlapi.repositories;

import com.mmdt.graphqlapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    // Find a user by email
    Optional<User> findByEmail(String email);

    // Find a user by phone number
    Optional<User> findByPhoneNo(String phoneNo);
}
