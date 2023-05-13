package proyecto.pontificia.elp.mi.registromatricula.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Alumno;
import proyecto.pontificia.elp.mi.registromatricula.api.model.Empleado;

public interface Empleadorepository extends JpaRepository<Empleado,Integer> {
}
