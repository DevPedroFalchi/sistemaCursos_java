package br.com.rm566967.cp2.sistema_cursos.dto;

public record ModuloRequest(
        String titulo,
        Integer ordem,
        Integer cargaHoraria)
    {
}
