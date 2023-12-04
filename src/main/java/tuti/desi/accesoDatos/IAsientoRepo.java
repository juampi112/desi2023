package tuti.desi.accesoDatos;

import tuti.desi.entidades.Asiento;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface IAsientoRepo extends JpaRepository<Asiento, Long> {
	
	//List<Asiento> findByVueloIdAndDisponible(Long vueloId, boolean disponible);
	
	@Query("select a from Asiento a where a.vuelo = ?1 and a.disponible = true")
	List<Asiento> findByVueloIdAndDisponible(Long vueloId);	
}