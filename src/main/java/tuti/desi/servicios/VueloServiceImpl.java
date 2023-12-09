
package tuti.desi.servicios;


import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;


@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	private IVueloRepo repo;

	
	@Override
	public List<Vuelo> getAll() {
		
		return repo.findAll();
	}


	@Override
	public Vuelo save(Vuelo v) throws Excepcion {

			return repo.save(v);
		
	}

	
	//el numero de vuelo debe ser unico
	@Override
	public boolean exist(String numVuelo) throws Excepcion {

		return repo.findBynumeroVuelo(numVuelo)!=null;
	}
	
	
	@Override
	public boolean existVueloRepetido(Avion avion,Date fechaVuelo) throws Excepcion {

		return repo.findByAvionAndfechaVuelo(avion, fechaVuelo) != null;

	}

}
