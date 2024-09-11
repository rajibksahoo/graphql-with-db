package com.mmdt.graphqlapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "meal_plans")
public class MealPlan {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;
    private LocalDate weekStartDate;
    private LocalDate weekEndDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DayMeal> dailyMeals;
}
