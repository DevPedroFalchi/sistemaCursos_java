package br.com.rm566967.cp2.sistema_cursos.dto;

public record ModuloResponse(
        Long id,
        String titulo,
        Integer ordem,
        Integer cargaHoraria)
    {
}
