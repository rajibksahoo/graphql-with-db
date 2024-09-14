package com.mmdt.graphqlapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MealInput {
    private String name;
    private String description;
    private int calories;
    private float protein;
    private float carbs;
    private float fats;
    private List<IngredientInput> ingredients;
    private List<InstructionInput> instructions;
}