package com.mmdt.graphqlapi.dtos;

import com.mmdt.graphqlapi.enums.Day;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class DayMealInput {
    private Day day;
    private int mealCount;
    private List<UUID> meals;
}
