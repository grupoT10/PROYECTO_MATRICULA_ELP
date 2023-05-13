package proyecto.pontificia.elp.mi.registromatricula.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalumno")
    private Integer id;

    private String codalumno;

    private String nombre;

    private String apepat;

    private String apemat;

    private String correo;

    private Date fnacimiento;

    @ManyToOne
    @JoinColumn(name = "idapoderado")
    private Apoderado idapoderado;
}
