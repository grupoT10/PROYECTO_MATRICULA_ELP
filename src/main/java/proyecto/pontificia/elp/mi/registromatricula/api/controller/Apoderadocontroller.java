package proyecto.pontificia.elp.mi.registromatricula.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto.ApoderadoDto;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Apoderado;
import proyecto.pontificia.elp.mi.registromatricula.api.repository.Apoderadorepository;


@RestController
@RequestMapping("/api/admin/apoderado")
public class Apoderadocontroller {

    private final Apoderadorepository apoderadorepository;

    public Apoderadocontroller(Apoderadorepository apoderadorepository){
        this.apoderadorepository = apoderadorepository;
    }

    @GetMapping("/lis")
    Page<Apoderado> index(@PageableDefault(sort = "codapoderado",size=5) Pageable pageable){
        return apoderadorepository.findAll(pageable);
    }

    @GetMapping("/lis/{id}")
    Apoderado obtener(@PathVariable Integer id){
        return apoderadorepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reg")
    Apoderado crear(@RequestBody @Validated ApoderadoDto apoderadoDto){
        Apoderado apoderado=new ModelMapper().map(apoderadoDto,Apoderado.class);
        return apoderadorepository.save(apoderado);

    }

    @PutMapping("/act/{id}")
    Apoderado actualizar(@PathVariable Integer id, @RequestBody ApoderadoDto apoderadoDto){
        Apoderado apoderado=apoderadorepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(apoderadoDto, apoderado);
        return apoderadorepository.save(apoderado);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eli/{id}")
    void eliminar(@PathVariable Integer id){
        Apoderado apoderado=apoderadorepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        apoderadorepository.delete(apoderado);


    }
}
