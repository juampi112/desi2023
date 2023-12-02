package tuti.desi.servicios;


import java.util.List;

import tuti.desi.entidades.ConsultaVuelo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.ConsultarVueloForm;

public interface ConsultarVueloService {


	List<Vuelo> buscarVuelos(ConsultarVueloForm vueloForm) throws Excepcion;

	List<ConsultaVuelo> findByParameters(ConsultarVueloForm vueloForm) throws Excepcion;
	
	
	
}
