package com.mmdt.graphqlapi.config;


import graphql.scalars.ExtendedScalars;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Configuration
public class GraphQlConfig {

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .scalar(ExtendedScalars.UUID)
                .scalar(ExtendedScalars.Date)
                .scalar(ExtendedScalars.DateTime)
                .scalar(localDateScalarType());
    }

    @Bean
    public GraphQLScalarType localDateScalarType() {
        return GraphQLScalarType.newScalar()
                .name("LocalDateTime")
                .description("LocalDateTime scalar")
                .coercing(new Coercing() {
                    @Override
                    public String serialize(Object input) {
                        // Define the formatter to handle the input LocalDateTime format
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS", Locale.ENGLISH);

                        // Convert the input to LocalDateTime if necessary
                        if (input instanceof LocalDateTime) {
                            return ((LocalDateTime) input).format(formatter);
                        } else if (input instanceof String) {
                            // Parse the string input as LocalDateTime, ignoring the offset
                            LocalDateTime dateTime = LocalDateTime.parse(((String) input).substring(0, 26));  // Ignore the time zone part
                            return dateTime.format(formatter);
                        } else {
                            throw new IllegalArgumentException("Unsupported input type: " + input.getClass());
                        }
                    }
                    @Override
                    public Object parseValue(Object o) throws CoercingParseValueException {
                        return o;
                    }

                    @Override
                    public Object parseLiteral(Object o) throws CoercingParseLiteralException {
                        return o.toString();
                    }
                })
                .build();

    }
}
