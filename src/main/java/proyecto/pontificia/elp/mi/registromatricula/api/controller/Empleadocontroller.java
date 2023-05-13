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
import proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto.EmpleadoDto;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Alumno;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Empleado;
import proyecto.pontificia.elp.mi.registromatricula.api.repository.Empleadorepository;

@RestController
@RequestMapping("/api/admin/empleado")
public class Empleadocontroller {

    private final Empleadorepository empleadorepository;

    public Empleadocontroller(Empleadorepository empleadorepository) {
        this.empleadorepository = empleadorepository;
    }
    @GetMapping("/lis")
    Page<Empleado> index(@PageableDefault(sort = "id",size=5) Pageable pageable){
        return empleadorepository.findAll(pageable);
    }

    @GetMapping("/lis/{id}")
    Empleado obtener(@PathVariable Integer id){
        return empleadorepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reg")
    Empleado crear(@RequestBody @Validated EmpleadoDto empleadoDto){
        Empleado empleado=new ModelMapper().map(empleadoDto,Empleado.class);
        return empleadorepository.save(empleado);

    }

    @PutMapping("/act/{id}")
    Empleado actualizar(@PathVariable Integer id, @RequestBody EmpleadoDto empleadoDto){
        Empleado empleado=empleadorepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(empleadoDto, empleado);
        return empleadorepository.save(empleado);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eli/{id}")
    void eliminar(@PathVariable Integer id){
        Empleado empleado=empleadorepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        empleadorepository.delete(empleado);

    }
}
