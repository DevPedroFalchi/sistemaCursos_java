package br.com.rm566967.cp2.sistema_cursos.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.ArrayList;


@NoArgsConstructor
@Entity
@Getter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String titulo;

    @Setter
    private String descricao;

    @Enumerated(EnumType.STRING)
    private CursoStatus status = CursoStatus.RASCUNHO;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Modulo> modulos = new ArrayList<>();

    public void setStatus(CursoStatus novo) {
        if (this.status != null && !this.status.podeIrPara(novo)) {
            throw new IllegalStateException(
                    "Transição inválida de " + this.status + " para " + novo);
        }
        this.status = novo;
    }
}
