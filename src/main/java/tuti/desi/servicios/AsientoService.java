package tuti.desi.servicios;

import java.util.List;

import tuti.desi.entidades.Asiento;
import tuti.desi.excepciones.Excepcion;


public interface AsientoService {

	List<Asiento> obtenerAsiento(Long vueloId)throws Excepcion;
	
}
