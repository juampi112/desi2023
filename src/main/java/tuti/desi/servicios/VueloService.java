package tuti.desi.servicios;

import java.sql.Date;
import java.util.List;
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;

public interface VueloService {

	Vuelo save(Vuelo v) throws Excepcion;

	boolean exist(String numVuelo) throws Excepcion;

	boolean existVueloRepetido(Avion avion, Date fechaVuelo) throws Excepcion;

	List<Vuelo> getAll();

	public void saveVueloConAsientos(Vuelo vuelo);
}
