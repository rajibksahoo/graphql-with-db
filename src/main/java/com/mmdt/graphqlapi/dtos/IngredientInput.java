package com.mmdt.graphqlapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientInput {
    private String name;
    private String quantity;
}