package proyecto.pontificia.elp.mi.registromatricula.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcarrera")
    private Integer id;
    private Integer nombre;
    @ManyToOne
    @JoinColumn(name = "idtipoinstitución")
    private Tipoinstitucion idtipoinstitucion;
}