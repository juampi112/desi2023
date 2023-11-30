package tuti.desi.servicios;

import java.util.List;

import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
/**
 * Clase que permite gestionar la entidad Avion en el sistema.
**/

public interface AvionService {

	
	List<Avion> getAll();

}
