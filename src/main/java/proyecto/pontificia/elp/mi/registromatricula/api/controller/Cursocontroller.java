package proyecto.pontificia.elp.mi.registromatricula.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto.CursoDto;

@RestController
@RequestMapping("/api/admin/curso")
public class Cursocontroller {
     private final Cursorepository cursorepository;

     public Cursocontroller(Cursorepository cursorepository) {
         this.cursorepository = cursorepository;
     }

     @GetMapping("/lis")
     Page<Curso> index(@PageableDefault(sort = "codalumno", size = 5) Pageable pageable) {
         return cursorepository.findAll(pageable);
     }

     @GetMapping("/lis/{id}")
     Curso obtener(@PathVariable Integer id) {
         return cursorepository.findById(id).orElseThrow(EntityNotFoundException::new);
     }

     @ResponseStatus(HttpStatus.CREATED)
     @PostMapping("/reg")
     Curso crear(@RequestBody @Validated CursoDto cursoDto) {
         Curso curso = new ModelMapper().map(cursoDto, Curso.class);
         return cursorepository.save(curso);

     }

     @PutMapping("/act/{id}")
     Curso actualizar(@PathVariable Integer id, @RequestBody CursoDto cursoDto) {
         Curso curso = cursorepository
                 .findById(id)
                 .orElseThrow(EntityNotFoundException::new);
         new ModelMapper().map(cursoDto, curso);
         return cursorepository.save(curso);
     }

     @ResponseStatus(HttpStatus.NO_CONTENT)
     @DeleteMapping("/eli/{id}")
     void eliminar(@PathVariable Integer id) {
         Curso curso = cursorepository
                 .findById(id)
                 .orElseThrow(EntityNotFoundException::new);
         cursorepository.delete(curso);
     }
 }


