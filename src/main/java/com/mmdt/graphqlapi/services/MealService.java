package com.mmdt.graphqlapi.services;

import com.mmdt.graphqlapi.dtos.MealInput;
import com.mmdt.graphqlapi.entities.Meal;
import com.mmdt.graphqlapi.helper.ExceptionHelper;
import com.mmdt.graphqlapi.mapper.graphql.InputMapper;
import com.mmdt.graphqlapi.repositories.MealRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MealService {

    private final MealRepository mealRepository;
    private final InputMapper inputMapper;

    public Meal getMealById(UUID id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> ExceptionHelper.throwResourceNotFoundException("Meal", id.toString()));
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public Meal createMeal(MealInput input) {
        Meal meal = inputMapper.toEntity(input);
        return mealRepository.save(meal);
    }

    public Meal updateMeal(UUID id, MealInput input) {
        Meal existingMeal = mealRepository.findById(id)
                .orElseThrow(() -> ExceptionHelper.throwResourceNotFoundException("Meal", id.toString()));

        Meal updatedMeal = inputMapper.toEntity(input);
        updatedMeal.setId(existingMeal.getId());
        return mealRepository.save(updatedMeal);
    }

    public boolean deleteMeal(UUID id) {
        Meal meal = mealRepository.findById(id)
                .orElseThrow(() -> ExceptionHelper.throwResourceNotFoundException("Meal", id.toString()));
        mealRepository.delete(meal);
        return true;
    }
}
