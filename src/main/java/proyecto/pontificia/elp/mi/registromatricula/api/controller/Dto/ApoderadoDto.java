package proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ApoderadoDto {

    @Size(min = 3 ,max = 25)
    private String codapoderado;

    private String padre;

    private String trabajopat;


    private String celularpat;


    private String dnipat;


    private String madre;


    private String trabajomat;


    private String celularmat;


    private String dnimat;
}
