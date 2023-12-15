package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tuti.desi.entidades.Cliente;
import tuti.desi.entidades.Vuelo;

public interface IVenderPasajeRepo extends JpaRepository<Cliente, Long> {

	Cliente findBydni(Long dni);

	@Query("select v from Vuelo v where v.Id = ?1")
	Vuelo findByNumeroVuelo(Long Id);
}
