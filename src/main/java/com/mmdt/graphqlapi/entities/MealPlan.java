package com.mmdt.graphqlapi.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "meal_plans")
public class MealPlan {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "week_start_date")
    private LocalDate weekStartDate;

    @Column(name = "week_end_date")
    private LocalDate weekEndDate;

    @Column(updatable = false) // Prevent updates to createdAt
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false) // Ensure updatedAt is always present
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();

    }

    /*@ElementCollection
    @CollectionTable(name = "meal_plan_days", joinColumns = @JoinColumn(name = "meal_plan_id"))
    private List<DayMeal> dailyMeals;*/
}
