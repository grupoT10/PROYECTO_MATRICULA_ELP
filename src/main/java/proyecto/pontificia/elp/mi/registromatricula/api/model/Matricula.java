package proyecto.pontificia.elp.mi.registromatricula.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmatricula")
    private Integer id;

    private String codmatricula;

    private String turno;

    private Date fechamatricula;

    private String montopagar;

    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno idalumno;

    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Curso idcurso;

    @ManyToOne
    @JoinColumn(name = "idcarrera")
    private Carrera idcarrera;

    @ManyToOne
    @JoinColumn(name = "idempleado")
    private Empleado idempleado;

}
