package br.com.rm566967.cp2.sistema_cursos.validation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultipleOfValidator implements ConstraintValidator<MultipleOf, Integer> {

    private int multiplo;

    @Override
    public void initialize(MultipleOf constraintAnnotation) {
        this.multiplo = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;   // nulo é tratado pelo @NotNull, não aqui
        }
        return value % multiplo == 0;
    }
}
