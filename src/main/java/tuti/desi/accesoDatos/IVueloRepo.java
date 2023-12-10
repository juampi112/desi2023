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
	
	Vuelo findBynumeroVuelo(String numeroVuelo);

	
	@Query("select v from Vuelo v where v.avion = ?1 and v.fechaVuelo = ?2")
	Vuelo findByAvionAndfechaVuelo(Avion avion, Date fechaVuelo);


	
	
}
