package tuti.desi.servicios;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
/**
 * Clase que permite gestionar la entidad Vuelo en el sistema.
 **/

public interface VueloService {

	
	Vuelo save(Vuelo v) throws Excepcion; //xq el save devuelve un vuelo?

	boolean exist(String numVuelo) throws Excepcion;
	
	boolean existVueloRepetido(Avion avion,Date fechaVuelo) throws Excepcion;
		
}
