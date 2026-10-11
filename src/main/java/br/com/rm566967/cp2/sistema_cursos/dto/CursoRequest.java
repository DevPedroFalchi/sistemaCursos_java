package br.com.rm566967.cp2.sistema_cursos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CursoRequest(
        @NotBlank @Size(max = 100) String titulo,
        @NotBlank @Size(max = 500) String descricao
) {
}
