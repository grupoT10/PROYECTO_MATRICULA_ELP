package proyecto.pontificia.elp.mi.registromatricula.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Carrera;

public interface Carrerarepository extends JpaRepository<Carrera,Integer> {
}
