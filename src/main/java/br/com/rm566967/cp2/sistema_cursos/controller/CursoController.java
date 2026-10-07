package br.com.rm566967.cp2.sistema_cursos.controller;

import br.com.rm566967.cp2.sistema_cursos.dto.CursoRequest;
import br.com.rm566967.cp2.sistema_cursos.dto.CursoResponse;
import br.com.rm566967.cp2.sistema_cursos.mapper.CursoMapper;
import br.com.rm566967.cp2.sistema_cursos.dto.PageResponse;
import br.com.rm566967.cp2.sistema_cursos.model.Curso;
import br.com.rm566967.cp2.sistema_cursos.service.CursoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/cursos")
@Validated
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @GetMapping
    public PageResponse<CursoResponse> getAllProjects(@RequestParam(required = false) CursoStatus status,
                                                      @RequestParam(required = false, defaultValue = "0") Integer page,
                                                      @RequestParam(required = false, defaultValue = "10") Integer sizePage){
        Page<Curso> pageResult = status != null
                ? this.CursoService.findbyStatus(status, page, sizePage)
                : this.CursoService.findAll(page, sizePage);
        return PageResponse.from(pageResult.map(CursoMapper::toResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> findById(@PathVariable @Positive Long id){
        return ResponseEntity.ok(
                CursoMapper.toResponse(
                        CursoService.findById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<CursoResponse> createCurso(@RequestBody @Valid CursoRequest request){
        Curso curso = new Curso();
        curso.setTitulo(request.titulo());
        curso.setDescricao(request.descricao());

        Curso salvo = cursoService.create(curso);
        return ResponseEntity.created(
                URI.create("/api/cursos/" + salvo.getId()))
                .body(CursoMapper.toResponse(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> updateCurso(@PathVariable Long id, @RequestBody CursoRequest request){
        Curso curso = cursoService.findById(id);
        curso.setTitulo(request.titulo);
        curso.setDescricao(request.descricao());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<void> deleteCurso(@PathVariable Long id){
        this.cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
