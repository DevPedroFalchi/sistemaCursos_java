package br.com.rm566967.cp2.sistema_cursos.service;
import br.com.rm566967.cp2.sistema_cursos.model.Modulo;
import br.com.rm566967.cp2.sistema_cursos.repository.ModuloRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ModuloServiceImpl implements ModuloService {
    @Override
    public Page<Modulo> findModuloId(Long moduloId, Integer page, Integer size) {
        return null;
    }

    private final ModuloRepository moduloRepository;

    public ModuloServiceImpl(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    @Override
    public Page<Modulo> findAll(Integer page, Integer size) {
        return moduloRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Modulo> findByCursoId(Long cursoId, Integer page, Integer size) {
        return moduloRepository.findByCursoId(cursoId, PageRequest.of(page, size));
    }

    @Override
    public Modulo findById(Long id) {
        return moduloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo não encontrado: " + id));
    }

    @Override
    public Modulo create(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    @Override
    public Modulo update(Long id, Modulo modulo) {
        findById(id);
        modulo.setId(id);
        return moduloRepository.save(modulo);
    }

    @Override
    public void delete(Long id) {
        moduloRepository.delete(findById(id));
    }
}