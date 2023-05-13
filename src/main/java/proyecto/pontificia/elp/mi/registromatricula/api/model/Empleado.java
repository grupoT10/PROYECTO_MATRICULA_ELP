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
    private String nombre;

    private String apellido_pat;

    private String apellido_mat;

    private String dni;

    private String celular;

    private String cargo;

    private String codempleado;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario idusuario;
}
