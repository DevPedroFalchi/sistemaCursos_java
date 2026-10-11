package br.com.rm566967.cp2.sistema_cursos.mapper;

import br.com.rm566967.cp2.sistema_cursos.dto.CursoRequest;
import br.com.rm566967.cp2.sistema_cursos.dto.CursoResponse;
import br.com.rm566967.cp2.sistema_cursos.model.Curso;

public final class CursoMapper {

    private CursoMapper(){}

    public static CursoResponse toResponse(Curso curso) {
        return new CursoResponse(
                curso.getId(),
                curso.getTitulo(),
                curso.getDescricao(),
                curso.getStatus()
        );
    }
}