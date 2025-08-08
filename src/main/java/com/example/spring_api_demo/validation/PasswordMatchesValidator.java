package com.example.spring_api_demo.validation;

import com.example.spring_api_demo.request.AccountRegister;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, AccountRegister> {
    @Override
    public boolean isValid(AccountRegister user, ConstraintValidatorContext context) {
        if (user.getPassword() == null || user.getConfirmPassword() == null) {
            return false;
        }
        // Check if password and confirmPassword are equal
        System.out.println("Compare: " + user.getPassword().equals(user.getConfirmPassword()));
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
