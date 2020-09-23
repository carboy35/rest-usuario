package cl.ionix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.ionix.entities.PerPersonas;
@Repository
public interface PerPersonasRepository extends CrudRepository<PerPersonas,Integer> {
	@Query("SELECT tbl FROM PerPersonas tbl WHERE tbl.name like CONCAT('%',:name,'%')")
	List<PerPersonas> findByName(@Param("name") String name);
	


}
