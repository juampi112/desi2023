package tuti.desi.servicios;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;


public interface AsientoService {

	List<Asiento> obtenerAsiento(Vuelo vueloId)throws Excepcion;

	Asiento save(Asiento a) throws Excepcion; 
}
