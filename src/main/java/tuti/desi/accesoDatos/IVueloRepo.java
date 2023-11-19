package tuti.desi.accesoDatos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Vuelo;

@Repository
public interface IVueloRepo extends JpaRepository<Vuelo, Long> {


//	@Query("SELECT c FROM Ciudad c WHERE c.nombre like ?1 or c.provincia.id=?2")
//	List<Ciudad> findByNombreOrIdProvincia(String nombre, Long idProvinciaSeleccionada);
//	
//	@Query("SELECT c FROM Ciudad c WHERE c.nombre like ?1 and c.provincia.id=?2")
//	List<Ciudad> findByNombreAndIdProvincia(String nombre, Long idProvinciaSeleccionada);
	
	Vuelo findBynumeroVuelo(String numeroVuelo);

	
	@Query("select v from Vuelo v where v.avion = ?1 and v.fechayHora = ?2")
	Vuelo findByAvionAndFechaYHora(Avion avion, Date fechayHora);

}
