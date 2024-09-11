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
@Table(name = "instructions")
public class Instruction {
    @Id
    @GeneratedValue
    private UUID id;

    private int stepNumber;
    private String description;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;
}
