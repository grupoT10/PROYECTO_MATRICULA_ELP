package proyecto.pontificia.elp.mi.registromatricula.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalumno")
    private Integer id;

    private String apepat;

    private String apemat;

    private String dni;

    private String celular;

    private String direccion;

    private String correo;

    private String edad;

    @ManyToOne
    @JoinColumn(name = "idapoderado")
    private Apoderado idapoderado;
}
