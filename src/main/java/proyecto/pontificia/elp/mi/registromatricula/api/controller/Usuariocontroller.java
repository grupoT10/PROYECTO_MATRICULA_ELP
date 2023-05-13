package proyecto.pontificia.elp.mi.registromatricula.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.elp.mi.registromatricula.api.controller.Dto.UsuarioDto;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Usuario;
import proyecto.pontificia.elp.mi.registromatricula.api.repository.Usuariorepository;

@RestController
@RequestMapping("/api/admin/usuario")
public class Usuariocontroller {

    private final Usuariorepository usuariorepository;

    public Usuariocontroller(Usuariorepository usuariorepository) {
        this.usuariorepository = usuariorepository;
    }
    @GetMapping("/lis")
    Page<Usuario> index(@PageableDefault(sort = "id",size=5) Pageable pageable){
        return usuariorepository.findAll(pageable);
    }

    @GetMapping("/lis/{id}")
    Usuario obtener(@PathVariable Integer id){
        return usuariorepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reg")
    Usuario crear(@RequestBody @Validated UsuarioDto usuarioDto){
        Usuario usuario=new ModelMapper().map(usuarioDto,Usuario.class);
        return usuariorepository.save(usuario);
    }

    @PutMapping("/act/{id}")
    Usuario actualizar(@PathVariable Integer id,@RequestBody UsuarioDto usuarioDto){
        Usuario usuario=usuariorepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(usuarioDto, usuario);
        return usuariorepository.save(usuario);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eli/{id}")
    void eliminar(@PathVariable Integer id){
        Usuario usuario=usuariorepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        usuariorepository.delete(usuario);
    }
}
