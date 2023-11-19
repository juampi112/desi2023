package tuti.desi.servicios;

import java.sql.Date;

import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
/**
 * Clase que permite gestionar la entidad Ciudad en el sistema.
 * @author kuttel
 * @version 1.0
 */

public interface VueloService {

	Vuelo save(Vuelo v) throws Excepcion;

	boolean exist(String numVuelo) throws Excepcion;
	
	boolean existVueloRepetido(Avion avion,Date fechayHora) throws Excepcion;
		
}
