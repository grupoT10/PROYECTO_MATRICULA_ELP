package proyecto.pontificia.elp.mi.registromatricula.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto.RolesDTO;
import proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto.UsuarioDto;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Roles;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Usuario;
import proyecto.pontificia.elp.mi.registromatricula.api.repository.Rolesrepository;

@RestController
@RequestMapping("/api/admin/roles")
public class Rolescontroller {

    private final Rolesrepository rolesrepository;

    public Rolescontroller(Rolesrepository rolesrepository) {
        this.rolesrepository = rolesrepository;
    }
    @GetMapping("/lis")
    Page<Roles> index(@PageableDefault(sort = "id",size=5) Pageable pageable){
        return rolesrepository.findAll(pageable);
    }

    @GetMapping("/lis/{id}")
    Roles obtener(@PathVariable Integer id){
        return rolesrepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reg")
    Roles crear(@RequestBody @Validated RolesDTO rolesDTO){
        Roles roles=new ModelMapper().map(rolesDTO,Roles.class);
        return rolesrepository.save(roles);
    }

    @PutMapping("/act/{id}")
    Roles actualizar(@PathVariable Integer id,@RequestBody RolesDTO rolesDTO){
        Roles roles=rolesrepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(rolesDTO, roles);
        return rolesrepository.save(roles);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eli/{id}")
    void eliminar(@PathVariable Integer id){
        Roles roles=rolesrepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        rolesrepository.delete(roles);
    }

}
