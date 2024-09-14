package com.mmdt.graphqlapi.resolvers;

import com.mmdt.graphqlapi.dtos.MealInput;
import com.mmdt.graphqlapi.entities.Meal;
import com.mmdt.graphqlapi.services.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MealResolver {

    private final MealService mealService;

    @QueryMapping
    public Meal getMeal(@Argument UUID id) {
        return mealService.getMealById(id);
    }

    @QueryMapping
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @MutationMapping
    public Meal createMeal(@Argument MealInput input) {
        return mealService.createMeal(input);
    }

    @MutationMapping
    public Meal updateMeal(@Argument UUID id, @Argument MealInput input) {
        return mealService.updateMeal(id, input);
    }

    @MutationMapping
    public Boolean deleteMeal(@Argument UUID id) {
        return mealService.deleteMeal(id);
    }
}
