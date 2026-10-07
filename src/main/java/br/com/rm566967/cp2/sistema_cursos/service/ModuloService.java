package br.com.rm566967.cp2.sistema_cursos.service;

import br.com.rm566967.cp2.sistema_cursos.model.Modulo;
import org.springframework.data.domain.Page;

public interface ModuloService {

    Page<Modulo> findAll(Integer page, Integer size);

    Page<Modulo> findModuloId(Long moduloid, Integer page, Integer size);

    Modulo findById(Long id);
    Modulo create(Modulo modulo);
    Modulo update(Long id, Modulo updated);
    void delete(Long id);
}
