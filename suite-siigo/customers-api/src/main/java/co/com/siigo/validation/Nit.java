package co.com.siigo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NitValidator.class)
@Documented
public @interface Nit {
    String message() default "NIT must be numeric and length 5..15";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
