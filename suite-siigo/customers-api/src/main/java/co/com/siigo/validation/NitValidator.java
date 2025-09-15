package co.com.siigo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NitValidator implements ConstraintValidator<Nit, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        if (value.length() < 5 || value.length() > 15) return false;
        for (char c : value.toCharArray()) if (!Character.isDigit(c)) return false;
        return true;
    }
}
