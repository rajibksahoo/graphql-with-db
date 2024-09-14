package com.mmdt.graphqlapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructionInput {
    private int stepNumber;
    private String description;
}
