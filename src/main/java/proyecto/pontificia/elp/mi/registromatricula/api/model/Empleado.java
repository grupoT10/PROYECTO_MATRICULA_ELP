package proyecto.pontificia.elp.mi.registromatricula.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempleado")
    private Integer id;

    private String codempleado;

    private String nombre;

    private String apellidopat;

    private String apellidomat;

    private String dni;

    private String celular;

    private String cargo;

    @ManyToOne
    @JoinColumn(name = "idusuariot")
    private Usuario idusuario;
}
