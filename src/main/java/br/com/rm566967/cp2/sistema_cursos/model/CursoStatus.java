package br.com.rm566967.cp2.sistema_cursos.model;

public enum CursoStatus {
    RASCUNHO {
        @Override
        public boolean podeIrPara(CursoStatus novo) {
            return novo == PUBLICADO || novo == ARQUIVADO;
        }
    },
    PUBLICADO {
        @Override
        public boolean podeIrPara(CursoStatus novo) {
            return novo == ARQUIVADO;
        }
    },
    ARQUIVADO {
        @Override
        public boolean podeIrPara(CursoStatus novo) {
            return false;
        }
    };

    public abstract boolean podeIrPara(CursoStatus novo);
}
