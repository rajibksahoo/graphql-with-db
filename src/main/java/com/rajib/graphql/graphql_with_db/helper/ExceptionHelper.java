package com.rajib.graphql.graphql_with_db.helper;

public class ExceptionHelper {
    public static RuntimeException throwResourceNotFoundException(){
        return new RuntimeException("Resource Not Found");
    }
}
