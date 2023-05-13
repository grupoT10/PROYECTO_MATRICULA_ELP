package proyecto.pontificia.elp.mi.registromatricula.api.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Tipoinstitucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtipoinstitucion")
    private Integer id;

    private String nombre;

}
