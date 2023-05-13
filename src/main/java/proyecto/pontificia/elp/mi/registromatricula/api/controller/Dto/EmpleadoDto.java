package proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Usuario;

@Data
public class EmpleadoDto {

    @Size(min = 1,max = 25)
    private String codempleado;

    private String nombre;

    private String apellidopat;

    private String apellidomat;

    private String dni;

    private String celular;

    private String cargo;

    private Usuario idusuario;
}
