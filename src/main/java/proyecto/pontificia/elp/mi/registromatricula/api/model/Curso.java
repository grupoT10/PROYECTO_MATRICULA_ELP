package proyecto.pontificia.elp.mi.registromatricula.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer id;

    private String codcurso;

    private String nomcurso;

    private String ciclo;

    @ManyToOne
    @JoinColumn(name = "iddocente")
    private Docente iddocente;
}
