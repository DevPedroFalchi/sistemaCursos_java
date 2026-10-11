package br.com.rm566967.cp2.sistema_cursos.dto;

import java.time.LocalDateTime;

public record ErroResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    String message) {
}
