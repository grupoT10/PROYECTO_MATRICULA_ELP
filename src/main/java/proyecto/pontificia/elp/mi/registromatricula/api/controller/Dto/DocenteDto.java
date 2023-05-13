package proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DocenteDto {
    @Size(min = 1,max = 25)
    private String coddocente;

    private String nombre;
}


