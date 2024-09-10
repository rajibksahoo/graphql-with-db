package com.rajib.graphql.graphql_with_db.services;

import com.rajib.graphql.graphql_with_db.entities.Order;
import com.rajib.graphql.graphql_with_db.helper.ExceptionHelper;
import com.rajib.graphql.graphql_with_db.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    //create order
    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    //get all order
    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }

    //get Single Order
    public Order getOrder(int orderId){
        return orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }

    //delete Order
    public boolean deleteOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }
}
