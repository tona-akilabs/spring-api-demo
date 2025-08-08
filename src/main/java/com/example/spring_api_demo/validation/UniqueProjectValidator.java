package com.example.spring_api_demo.validation;

import com.example.spring_api_demo.repository.ProjectRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueProjectValidator implements ConstraintValidator<UniqueProject, String> {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return !projectRepository.existsByName(name);
    }
}
