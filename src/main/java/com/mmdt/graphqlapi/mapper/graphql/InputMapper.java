package com.mmdt.graphqlapi.mapper.graphql;


import com.mmdt.graphqlapi.dtos.UserInput;
import com.mmdt.graphqlapi.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InputMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toEntity(UserInput userInput);


}
