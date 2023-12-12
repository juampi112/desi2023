package tuti.desi.servicios;


import java.util.List;

import tuti.desi.entidades.Cliente;
import tuti.desi.entidades.ConsultaVuelo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.ConsultarVueloForm;
import tuti.desi.presentacion.VenderPasajeForm;

public interface VenderPasajeService {


	Cliente buscarCliente(VenderPasajeForm venderPasajeForm) throws Excepcion;

	Vuelo buscarVuelos(VenderPasajeForm venderPasajeForm) throws Excepcion;
}
