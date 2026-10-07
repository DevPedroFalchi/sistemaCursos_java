package br.com.rm566967.cp2.sistema_cursos.service;

import br.com.rm566967.cp2.sistema_cursos.model.Curso;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    Page<Curso> findAll(Integer page, Integer size);

    Curso findById(Long id);
    Curso create(Curso curso);
    Curso update(Long id, Curso curso);
    void delete(Long id);
}
