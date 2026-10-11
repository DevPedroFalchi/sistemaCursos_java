package br.com.rm566967.cp2.sistema_cursos.controller;
import br.com.rm566967.cp2.sistema_cursos.dto.ModuloRequest;
import br.com.rm566967.cp2.sistema_cursos.dto.ModuloResponse;
import br.com.rm566967.cp2.sistema_cursos.mapper.ModuloMapper;
import br.com.rm566967.cp2.sistema_cursos.dto.PageResponse;
import br.com.rm566967.cp2.sistema_cursos.model.Modulo;
import br.com.rm566967.cp2.sistema_cursos.service.ModuloService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@Validated
public class ModuloController {

    private final ModuloService moduloService;

    public ModuloController(ModuloService moduloService){
        this.moduloService = moduloService;
    }

    @GetMapping("/api/cursos/{cursoId}/modulos")
    public PageResponse<ModuloResponse> findByCurso(@PathVariable @Positive Long cursoId,
                                                    @RequestParam(required = false, defaultValue = "0") Integer page,
                                                    @RequestParam(required = false, defaultValue = "10") Integer sizePage) {

        Page<Modulo> pageResult = moduloService.findByCursoId(cursoId, page, sizePage);
        return PageResponse.from(pageResult.map(ModuloMapper::toResponse));
    }

    @GetMapping("/api/modulos/{id}")
    public ResponseEntity<ModuloResponse> findById(@PathVariable @Positive Long id){
        Modulo modulo = moduloService.findById(id);
        return ResponseEntity.ok(ModuloMapper.toResponse(modulo));
    }

    @PostMapping("/api/cursos/{cursoId}/modulos")
    public ResponseEntity<ModuloResponse> create(@PathVariable @Positive Long cursoId,
                                                 @RequestBody @Valid ModuloRequest request) {
        Modulo created = moduloService.create(cursoId, request);
        return ResponseEntity.created(URI.create("/api/modulos/" + created.getId()))
                .body(ModuloMapper.toResponse(created));
    }

    @DeleteMapping("/api/modulos/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Positive Long id){
        moduloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
