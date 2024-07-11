package com.rin.identity.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class TextValidator implements ConstraintValidator<TextConstraint, String> {

    private String value;

    @Override
    public void initialize(TextConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        value=constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(value))
            return false;

        return !value.isEmpty();
    }
}
