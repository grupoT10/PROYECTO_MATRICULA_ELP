package proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Tipoinstitucion;

@Data
public class CarreraDto {

    private String nombre;

    private Tipoinstitucion idtipoinstitucion;
}

