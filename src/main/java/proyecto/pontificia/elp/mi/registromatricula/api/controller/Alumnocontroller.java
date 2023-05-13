package proyecto.pontificia.elp.mi.registromatricula.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto.AlumnoDto;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Alumno;
import proyecto.pontificia.elp.mi.registromatricula.api.repository.Alumnorepository;

@RestController
@RequestMapping("/api/admin/alumno")
public class Alumnocontroller {

    private final Alumnorepository alumnorepository;

    public Alumnocontroller(Alumnorepository alumnorepository){
        this.alumnorepository = alumnorepository;
    }

    @GetMapping("/lis")
    Page<Alumno> index(@PageableDefault(sort = "id",size=5) Pageable pageable){
        return alumnorepository.findAll(pageable);
    }

    @GetMapping("/lis/{id}")
    Alumno obtener(@PathVariable Integer id){
        return alumnorepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reg")
    Alumno crear(@RequestBody @Validated AlumnoDto alumnoDto){
        Alumno alumno=new ModelMapper().map(alumnoDto,Alumno.class);
        return alumnorepository.save(alumno);

    }

    @PutMapping("/act/{id}")
    Alumno actualizar(@PathVariable Integer id, @RequestBody AlumnoDto alumnoDto){
        Alumno alumno=alumnorepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(alumnoDto, alumno);
        return alumnorepository.save(alumno);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eli/{id}")
    void eliminar(@PathVariable Integer id){
        Alumno alumno=alumnorepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        alumnorepository.delete(alumno);


    }
}
