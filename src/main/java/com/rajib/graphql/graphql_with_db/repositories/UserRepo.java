package com.rajib.graphql.graphql_with_db.repositories;

import com.rajib.graphql.graphql_with_db.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
