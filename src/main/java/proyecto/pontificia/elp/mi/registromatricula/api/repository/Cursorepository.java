package proyecto.pontificia.elp.mi.registromatricula.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Curso;

public interface Cursorepository extends JpaRepository <Curso,Integer> {
}