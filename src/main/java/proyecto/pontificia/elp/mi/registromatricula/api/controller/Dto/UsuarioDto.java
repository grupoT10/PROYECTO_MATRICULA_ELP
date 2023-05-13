package proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioDto {
    @NotBlank
    @Size(min = 1,max = 25)
    private String codusuario;

    private String nombre;

    private String user;

    private String password;
}

