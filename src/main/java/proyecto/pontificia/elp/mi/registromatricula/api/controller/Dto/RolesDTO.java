package proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RolesDTO {

    @Size(min = 1,max = 25)
    private String idroles;

    private String nombre;
}

