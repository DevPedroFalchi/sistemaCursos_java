package br.com.rm566967.cp2.sistema_cursos.dto;
import br.com.rm566967.cp2.sistema_cursos.validation.MultipleOf;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ModuloRequest(
        @NotBlank
        @Size(max = 100)
        String titulo,

        @NotNull
        @Positive
        Integer ordem,


        @NotNull
        @MultipleOf(5)
        Integer cargaHoraria) {
}
