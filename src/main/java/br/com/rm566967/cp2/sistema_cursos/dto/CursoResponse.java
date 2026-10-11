package br.com.rm566967.cp2.sistema_cursos.dto;

import br.com.rm566967.cp2.sistema_cursos.model.CursoStatus;

public record CursoResponse(
        Long id,
        String titulo,
        String descricao,
        CursoStatus status)
    {
}
