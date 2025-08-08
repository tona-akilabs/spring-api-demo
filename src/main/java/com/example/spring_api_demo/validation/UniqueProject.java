package com.example.spring_api_demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueProjectValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueProject {
    String message() default "projectName already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
