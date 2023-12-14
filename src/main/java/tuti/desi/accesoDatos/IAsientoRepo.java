package tuti.desi.accesoDatos;

import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Vuelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface IAsientoRepo extends JpaRepository<Asiento, Long> {
		
	@Query("select a from Asiento a where a.vuelo = ?1 and a.disponible = true")
	List<Asiento> findByVueloIdAndDisponible(Vuelo vueloId);	
	@Query("select Count(a) from Asiento a where a.vuelo = ?1 and a.disponible = true")
	Integer totalAsientosDisponibles(Vuelo vueloId);
}
