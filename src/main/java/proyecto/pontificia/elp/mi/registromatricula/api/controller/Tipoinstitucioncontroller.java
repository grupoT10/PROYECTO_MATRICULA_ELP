package proyecto.pontificia.elp.mi.registromatricula.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto.TipoinstitucionDto;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Tipoinstitucion;
import proyecto.pontificia.elp.mi.registromatricula.api.repository.Tipoinstitucionrepository;

@RestController
@RequestMapping("/api/admin/tipoinstitucion")

public class Tipoinstitucioncontroller {
        private final Tipoinstitucionrepository tipoinstitucionrepository;

        public Tipoinstitucioncontroller(Tipoinstitucionrepository tipoinstitucionrepository){
            this.tipoinstitucionrepository = tipoinstitucionrepository;
        }

    @GetMapping("/lis")
        Page<Tipoinstitucion> index(@PageableDefault(sort = "nombre",size=5) Pageable pageable){
            return tipoinstitucionrepository.findAll(pageable);
        }

        @GetMapping("/lis/{id}")
        Tipoinstitucion obtener(@PathVariable Integer id){
            return tipoinstitucionrepository.findById(id).orElseThrow(EntityNotFoundException::new);
        }

        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping("/reg")
        Tipoinstitucion crear(@RequestBody @Validated TipoinstitucionDto tipoinstitucionDto){
            Tipoinstitucion tipoinstitucion=new ModelMapper().map(tipoinstitucionDto,Tipoinstitucion.class);
            return tipoinstitucionrepository.save(tipoinstitucion);

        }

        @PutMapping("/act/{id}")
        Tipoinstitucion actualizar(@PathVariable Integer id, @RequestBody TipoinstitucionDto tipoinstitucionDto){
            Tipoinstitucion tipoinstitucion=tipoinstitucionrepository
                    .findById(id)
                    .orElseThrow(EntityNotFoundException::new);
            new ModelMapper().map(tipoinstitucionDto, tipoinstitucion);
            return tipoinstitucionrepository.save(tipoinstitucion);
        }

        @ResponseStatus(HttpStatus.NO_CONTENT)
        @DeleteMapping("/eli/{id}")
        void eliminar(@PathVariable Integer id){
                Tipoinstitucion tipoinstitucion=tipoinstitucionrepository
                    .findById(id)
                    .orElseThrow(EntityNotFoundException::new);
            tipoinstitucionrepository.delete(tipoinstitucion);


        }
    }


