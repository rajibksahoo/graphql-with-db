package com.mmdt.graphqlapi.services;


import com.mmdt.graphqlapi.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;
}
