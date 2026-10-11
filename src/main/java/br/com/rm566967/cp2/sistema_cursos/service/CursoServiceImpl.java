package br.com.rm566967.cp2.sistema_cursos.service;
import br.com.rm566967.cp2.sistema_cursos.model.CursoStatus;
import br.com.rm566967.cp2.sistema_cursos.model.Curso;
import br.com.rm566967.cp2.sistema_cursos.repository.CursoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Page<Curso> findAll(Integer page, Integer size) {
        return cursoRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Curso> findByStatus(CursoStatus status, Integer page, Integer size) {
        return cursoRepository.findByStatus(status, PageRequest.of(page, size));
    }

    @Override
    public Curso findById(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado: " + id));
    }

    @Override
    public Curso create(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Long id, Curso curso) {
        Curso existente = findById(id);          // já tem o id e o status atuais
        existente.setTitulo(curso.getTitulo());
        existente.setDescricao(curso.getDescricao());
        return cursoRepository.save(existente);
    }

    @Override
    public void delete(Long id) {
        Curso existente = findById(id);
        cursoRepository.delete(existente);
    }
}