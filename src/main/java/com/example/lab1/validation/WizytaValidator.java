package com.example.lab1.validation;

import com.example.lab1.domain.wizyta;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class WizytaValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return wizyta.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        wizyta w = (wizyta) target;

        if ("Test".equalsIgnoreCase(w.getImie())) {
            errors.rejectValue("nazwa", "error.nazwa.test", "Nazwa zabiegu nie może być słowem 'Test'");
        }
    }
}