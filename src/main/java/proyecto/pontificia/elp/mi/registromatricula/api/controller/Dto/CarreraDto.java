package proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CarreraDto {
    @NotBlank
    @Size(min = 5,max = 50)
    private String nombre;


    private String tipoinstitucion;
}

