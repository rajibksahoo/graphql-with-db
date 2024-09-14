package com.mmdt.graphqlapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class MealPlanInput {
    private UUID userId;
    private LocalDate weekStartDate;
    private LocalDate weekEndDate;
    private List<DayMealInput> dailyMeals;
}