package proyecto.pontificia.elp.mi.registromatricula.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto.DocenteDto;

@RestController
@RequestMapping("/api/admin/doncete")
public class Docentecontroller {


    private final Docenterepository docenterepository;

    public Docentecontroller(Docenterepository docenterepository) {
        this.docenterepository = docenterepository;
    }

    @GetMapping("/lis")
    Page<Docente> index(@PageableDefault(sort = "codalumno", size = 5) Pageable pageable) {
        return docenterepository.findAll(pageable);
    }

    @GetMapping("/lis/{id}")
    Docente obtener(@PathVariable Integer id) {
        return docenterepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reg")
    Docente crear(@RequestBody @Validated DocenteDto docenteDt) {
        Docente docente = new ModelMapper().map(docenteDt, Docente.class);
        return docenterepository.save(docente);

    }

    @PutMapping("/act/{id}")
    Docente actualizar(@PathVariable Integer id, @RequestBody DocenteDto docenteDto) {
        Docente docente = docenterepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(docenteDto, docente);
        return docenterepository.save(docente);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eli/{id}")
    void eliminar(@PathVariable Integer id) {
        Docente docente = docenterepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        docenterepository.delete(docente);
    }
}

