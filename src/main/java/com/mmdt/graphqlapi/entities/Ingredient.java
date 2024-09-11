package com.mmdt.graphqlapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;
}

