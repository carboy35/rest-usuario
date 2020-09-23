package cl.ionix.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.ionix.entities.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
	
	@Query("SELECT u FROM Usuario u WHERE u.email= :email")
	List<Usuario> getByEmail(@Param("email") String email);

}
