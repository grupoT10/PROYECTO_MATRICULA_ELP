package proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Apoderado;

import java.util.Date;

@Data
public class AlumnoDto {

    @NotBlank
    @Size(min = 1,max = 25)
    private String codalumno;


    private String nombre;


    private String apepat;


    private String apemat;


    private String correo;


    private Date fnacimiento;


    private Apoderado idapoderado;
}
