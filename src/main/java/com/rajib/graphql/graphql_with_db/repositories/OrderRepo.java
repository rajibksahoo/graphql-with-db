package com.rajib.graphql.graphql_with_db.repositories;

import com.rajib.graphql.graphql_with_db.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo  extends JpaRepository<Order,Integer> {
}

