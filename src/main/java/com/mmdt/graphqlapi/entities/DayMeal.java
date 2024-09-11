package com.mmdt.graphqlapi.entities;

import com.mmdt.graphqlapi.enums.Day;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class DayMeal {
    @Enumerated(EnumType.STRING)
    private Day day;

    private int mealCount;

    @ManyToMany
    private List<Meal> meals;
}
