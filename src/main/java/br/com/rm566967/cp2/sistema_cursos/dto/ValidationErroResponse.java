package br.com.rm566967.cp2.sistema_cursos.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ValidationErroResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        List<FieldError> errors) {

    public record FieldError(String campo, String mensagem) {}
}
