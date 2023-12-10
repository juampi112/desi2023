package tuti.desi.accesoDatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Cliente;
import tuti.desi.entidades.ConsultaVuelo;
import tuti.desi.entidades.Vuelo;

public interface IVenderPasajeRepo extends JpaRepository<Cliente, Long>{

	Cliente findBydni(Long dni);
	
	@Query("select v from Vuelo v where v.numeroVuelo = ?1")
	Vuelo findByNumeroVuelo(String numeroVuelo );
}

