package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.ManyToOne;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.ConsultaVuelo;
import tuti.desi.entidades.Vuelo;

public interface IConsultarVueloRepo extends JpaRepository<Vuelo, Long> {

	@Query("SELECT v FROM Vuelo v")
	List<Vuelo> buscarVuelosAll();

	@Query("SELECT v FROM Vuelo v WHERE ( v.fechaVuelo = :date) "
			+ "AND (:ciudadOrigen IS NULL OR v.ciudadOrigen = :ciudadOrigen) "
			+ "AND (:ciudadDestino IS NULL OR v.ciudadDestino = :ciudadDestino) "
			+ "AND (:TipoDeVuelo IS NULL OR :TipoDeVuelo = '' OR v.TipoDeVuelo = :TipoDeVuelo) "
			+ "ORDER BY v.horaVuelo")
	List<Vuelo> findByfechaVuelo(@Param("date") Date date, @Param("ciudadOrigen") Ciudad ciudadOrigen,
			@Param("ciudadDestino") Ciudad ciudadDestino, @Param("TipoDeVuelo") String TipoDeVuelo);

}