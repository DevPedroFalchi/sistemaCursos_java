package br.com.rm566967.cp2.sistema_cursos.mapper;

import br.com.rm566967.cp2.sistema_cursos.dto.ModuloResponse;
import br.com.rm566967.cp2.sistema_cursos.model.Modulo;
import org.apache.catalina.mapper.Mapper;

public final class ModuloMapper {

    private ModuloMapper(){}

    public static ModuloResponse toResponse(Modulo modulo){
        return new ModuloResponse(
                modulo.getId(),
                modulo.getTitulo(),
                modulo.getOrdem(),
                modulo.getCargaHoraria()
        );
    }
}
