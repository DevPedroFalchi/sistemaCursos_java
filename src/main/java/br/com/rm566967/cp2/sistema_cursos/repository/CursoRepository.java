package br.com.rm566967.cp2.sistema_cursos.repository;

import br.com.rm566967.cp2.sistema_cursos.controller.CursoStatus;
import br.com.rm566967.cp2.sistema_cursos.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Page<Curso> findByStatus(CursoStatus status, PageRequest of);
}
