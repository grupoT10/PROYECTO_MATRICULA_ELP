package proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TipoinstitucionDto {

    @NotBlank
    @Size(min = 3 ,max = 25)
    private String tipoinstitucion;

    private String nombre;

}
