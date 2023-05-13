package proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.awt.*;

@Data
public class CursoDto {
    @Size(min = 1, max = 25)
    private String codcurso;


    private String nomcurso;

    private String Ciclo;

    private Cursor iddocente;
}