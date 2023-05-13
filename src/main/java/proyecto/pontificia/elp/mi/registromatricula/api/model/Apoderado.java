package proyecto.pontificia.elp.mi.registromatricula.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Apoderado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idapoderado")
    private Integer id;

    private String codapoderado;

    private String padre;

    private String trabajopat;

    private String celularpat;

    private String dnipat;

    private String madre;

    private String trabajomat;

    private String celularmat;

    private String dnimat;
}
