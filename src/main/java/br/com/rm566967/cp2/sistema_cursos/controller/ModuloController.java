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

@RestController
@RequestMapping("/api/modulos")
@Validated
public class ModuloController {

    private final ModuloService moduloService;

    public ModuloController(ModuloService moduloService){
        this.moduloService = moduloService;
    }

    @GetMapping
    public PageResponse<ModuloResponse> findAll(@RequestParam(required = false) Long id,
                                                @RequestParam(required = false, defaultValue = "0") Integer page,
                                                @RequestParam(required = false, defaultValue = "10") Integer sizePage){

        return PageResponse.from(pageResult.map(ModuloMapper::toResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ModuloResponse>> findById(@PathVariable @Positive Long id){
        Modulo modulo = moduloService.findById(id);
        return moduloService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ModuloResponse> create(@RequestBody @Valid ModuloRequest request){
        Modulo modulo = new Modulo();
        modulo.setTitulo(request.titulo());
        modulo.setCargaHoraria(request.cargaHoraria());
        modulo.setOrdem(request.ordem());
        Modulo created = ModuloService.create();
        return ResponseEntity.ok(ModuloMapper.toResponse(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuloResponse> update(@PathVariable @Positive Long id, @RequestBody @Valid ModuloRequest request){
        Modulo modulo = moduloService.findById(id);
        modulo.setTitulo(request.titulo());
        modulo.setCargaHoraria(request.cargaHoraria());
        modulo.setOrdem(request.ordem());

        Modulo updated = moduloService.update(id, modulo);
        return ResponseEntity.ok(ModuloMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Positive Long id){
        moduloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
