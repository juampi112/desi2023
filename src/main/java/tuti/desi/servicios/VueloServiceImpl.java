
package tuti.desi.servicios;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;


@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	private IVueloRepo repo;

	



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
	public boolean existVueloRepetido(Avion avion,Date fechayHora) throws Excepcion {

		return repo.findByAvionAndFechaYHora(avion, fechayHora) != null;

	}

}
