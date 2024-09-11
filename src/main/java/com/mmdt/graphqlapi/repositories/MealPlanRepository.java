package com.mmdt.graphqlapi.repositories;

import com.mmdt.graphqlapi.entities.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, UUID> {
    // Custom query methods can be added here if needed
}

