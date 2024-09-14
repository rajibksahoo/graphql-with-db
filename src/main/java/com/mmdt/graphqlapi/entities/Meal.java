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

    @Column(updatable = false) // Prevent updates to createdAt
    private  LocalDateTime createdAt = LocalDateTime.now();

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
}

