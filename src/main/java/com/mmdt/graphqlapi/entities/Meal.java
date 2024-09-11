package com.mmdt.graphqlapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private int calories;
    private float protein;
    private float carbs;
    private float fats;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
    private List<Instruction> instructions;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

