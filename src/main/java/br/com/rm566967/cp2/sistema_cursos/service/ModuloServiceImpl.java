package br.com.rm566967.cp2.sistema_cursos.service;
import br.com.rm566967.cp2.sistema_cursos.dto.ModuloRequest;
import br.com.rm566967.cp2.sistema_cursos.exceptions.ResourceNotFoundException;
import br.com.rm566967.cp2.sistema_cursos.model.Curso;
import br.com.rm566967.cp2.sistema_cursos.model.Modulo;
import br.com.rm566967.cp2.sistema_cursos.repository.CursoRepository;
import br.com.rm566967.cp2.sistema_cursos.repository.ModuloRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ModuloServiceImpl implements ModuloService {

    private final ModuloRepository moduloRepository;
    private final CursoRepository cursoRepository;

    public ModuloServiceImpl(ModuloRepository moduloRepository,
                             CursoRepository cursoRepository) {
        this.moduloRepository = moduloRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Page<Modulo> findAll(Integer page, Integer size) {
        return moduloRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Modulo> findByCursoId(Long cursoId, Integer page, Integer size) {
        if (!cursoRepository.existsById(cursoId)) {
            throw new ResourceNotFoundException("Curso não encontrado: " + cursoId);
        }
        return moduloRepository.findByCursoId(cursoId, PageRequest.of(page, size));
    }

    @Override
    public Modulo findById(Long id) {
        return moduloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Módulo não encontrado: " + id));
    }

    @Override
    public Modulo create(Long cursoId, ModuloRequest request) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado: " + cursoId));

        Modulo modulo = new Modulo();
        modulo.setTitulo(request.titulo());
        modulo.setOrdem(request.ordem());
        modulo.setCargaHoraria(request.cargaHoraria());
        modulo.setCurso(curso);

        return moduloRepository.save(modulo);
    }

    @Override
    public Modulo update(Long id, Modulo modulo) {
        Modulo existente = findById(id);
        existente.setTitulo(modulo.getTitulo());
        existente.setOrdem(modulo.getOrdem());
        existente.setCargaHoraria(modulo.getCargaHoraria());
        return moduloRepository.save(existente);
    }

    @Override
    public void delete(Long id) {
        moduloRepository.delete(findById(id));
    }
}