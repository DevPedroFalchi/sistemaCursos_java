package br.com.rm566967.cp2.sistema_cursos.validation;

import jakarta.validation.Payload;

public @interface MultipleOf {

    int value();

    String message() default "deve ser múltiplo de {value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
