package proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Alumno;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Carrera;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Curso;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Empleado;

import java.util.Date;

@Data
public class MatriculaDto {

    @Size(min = 1, max = 25)
    private String codmatricula;

    private String turno;

    private Date fechamatricula;

    private String montopagar;

    private Alumno idalumno;

    private Curso idcurso;

    private Carrera idcarrera;

    private Empleado idempleado;

}
