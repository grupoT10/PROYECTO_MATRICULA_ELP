package proyecto.pontificia.elp.mi.registromatricula.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto.CarreraDto;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Carrera;
import proyecto.pontificia.elp.mi.registromatricula.api.repository.Carrerarepository;

@RestController
@RequestMapping("/api/admin/carrera")
public class Carreracontroller {

    private final Carrerarepository carrerarepository;
    public Carreracontroller(Carrerarepository carrerarepository){
        this.carrerarepository = carrerarepository;
    }
    @GetMapping("/lis")
    Page<Carrera> index(@PageableDefault(sort = "nombre",size=10) Pageable pageable){
        return carrerarepository.findAll(pageable);
    }

    @GetMapping("/lis/{id}")
    Carrera obtener(@PathVariable Integer id){
        return carrerarepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reg")
    Carrera crear(@RequestBody @Validated CarreraDto carreraDto){
        Carrera carrera=new ModelMapper().map(carreraDto,Carrera.class);
        return carrerarepository.save(carrera);

    }

    @PutMapping("/act/{id}")
    Carrera actualizar(@PathVariable Integer id, @RequestBody CarreraDto carreraDto){
        Carrera carrera=carrerarepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(carreraDto, carrera);
        return carrerarepository.save(carrera);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eli/{id}")
    void eliminar(@PathVariable Integer id){
        Carrera carrera=carrerarepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        carrerarepository.delete(carrera);


    }
}

