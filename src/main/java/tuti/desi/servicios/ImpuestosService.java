package tuti.desi.servicios;

import java.util.List;

import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.ImpuestosYTasas;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
/**
 * Clase que permite gestionar la entidad ImpuestosYTasas en el sistema.
**/

public interface ImpuestosService {

	ImpuestosYTasas save(ImpuestosYTasas v) throws Excepcion;

	ImpuestosYTasas getBy_Id(Long id) ;

}
