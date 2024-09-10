package com.rajib.graphql.graphql_with_db.controllers;

import com.rajib.graphql.graphql_with_db.entities.Order;
import com.rajib.graphql.graphql_with_db.entities.User;
import com.rajib.graphql.graphql_with_db.services.OrderService;
import com.rajib.graphql.graphql_with_db.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {
    private UserService userService;
    private OrderService orderService;

    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    //createOrder
    @MutationMapping
    public Order createOrder(
            @Argument String date,
            @Argument int amount,
            @Argument int userId
    ) {
        User user = userService.getUser(userId);
        Order order = new Order();
        order.setUser(user);
        order.setDate(date);
        order.setAmount(amount);
        return orderService.createOrder(order);
    }

    //deleteOrder
    @MutationMapping
    public boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);
    }

    // getAllOrders
    @QueryMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrder();
    }

    //getOrder
    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return orderService.getOrder(orderId);
    }

}
