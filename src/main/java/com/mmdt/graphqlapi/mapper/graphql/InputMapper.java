package com.mmdt.graphqlapi.mapper.graphql;


import com.mmdt.graphqlapi.dtos.*;
import com.mmdt.graphqlapi.entities.*;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        builder =@Builder(disableBuilder = true))
public interface InputMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    User toEntity(UserInput userInput);

    @Mapping(target = "id", ignore = true)
    User userToUser(User user);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Meal toEntity(MealInput mealInput );

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    MealPlan toEntity(MealPlanInput mealPlanInput);

    @Mapping(target = "id", ignore = true)
    Instruction toEntity(InstructionInput instructionInput);

    Ingredient toEntity(IngredientInput ingredientInput);


}
