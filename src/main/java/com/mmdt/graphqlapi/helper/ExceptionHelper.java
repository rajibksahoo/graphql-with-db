package com.mmdt.graphqlapi.helper;

import com.mmdt.graphqlapi.exceptions.ResourceNotFoundException;

public class ExceptionHelper {

    public static ResourceNotFoundException throwResourceNotFoundException(String resourceName, String resourceId) {
        return new ResourceNotFoundException(resourceName + " with ID " + resourceId + " not found");
    }
}
