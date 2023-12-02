package tuti.desi.accesoDatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.sql.Date;
import java.util.List;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Vuelo;

public interface IConsultarVueloRepo extends JpaRepository<Vuelo, Long>{

	
   /* @Query("SELECT v.fechaVuelo, v.horaVuelo ,v.numeroVuelo ,v.TipoDeVuelo ,v.estado ,v.avion.capacidad "
    		+ "FROM Vuelo v WHERE (v.fechaVuelo = ?1) " +
          "and (?2 is null or v.ciudadOrigen = ?2) " +
           "and (?3 is null or v.ciudadDestino = ?3) " +
           "and (?4 is null or v.tipoDeVuelo = ?4)" +
           "ORDER BY v.horaVuelo" )
    List<Vuelo> buscarVuelos(Date fechaAconsultar, Long ciudadOrigen_Aconsultar, Long ciudadDestino_Aconsultar, String tipoDeVuelo_Aconsultar);*/
    
    List<Vuelo> findByfechaVuelo(Date fechaAconsultar);
}