package com.example.householdbudget.validation;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredLocalDateValidator implements ConstraintValidator<RequiredLocalDate, LocalDate> {
    
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return value != null;
    }
}