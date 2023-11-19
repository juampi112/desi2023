package tuti.desi.servicios;

import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
/**
 * Clase que permite gestionar la entidad Ciudad en el sistema.
 * @author kuttel
 * @version 1.0
 */

public interface VueloService {

	

	Vuelo save(Vuelo v) throws Excepcion;
	
}
