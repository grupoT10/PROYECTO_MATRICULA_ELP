package proyecto.pontificia.elp.mi.registromatricula.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto.MatriculaDto;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Matricula;
import proyecto.pontificia.elp.mi.registromatricula.api.repository.Matricularepository;

@RestController
@RequestMapping("/api/admin/matricula")
public class Matriculacontroller {

    private final Matricularepository matricularepository;

    public Matriculacontroller(Matricularepository matricularepository){
        this.matricularepository = matricularepository;
    }

    @GetMapping("/lis")
    Page<Matricula> index(@PageableDefault(sort = "codmatricula",size=5)Pageable pageable){
        return matricularepository.findAll(pageable);
    }

    @GetMapping("/lis/{id}")
    Matricula obtener(@PathVariable Integer id){
        return matricularepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reg")
    Matricula crear(@RequestBody @Validated MatriculaDto matriculaDto){
        Matricula matricula=new ModelMapper().map(matriculaDto,Matricula.class);
        return matricularepository.save(matricula);

    }

    @PutMapping("/act/{id}")
    Matricula actualizar(@PathVariable Integer id, @RequestBody MatriculaDto matriculaDto){
        Matricula matricula=matricularepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(matriculaDto, matricula);
        return matricularepository.save(matricula);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eli/{id}")
    void eliminar(@PathVariable Integer id){
        Matricula matricula=matricularepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        matricularepository.delete(matricula);


    }

}
