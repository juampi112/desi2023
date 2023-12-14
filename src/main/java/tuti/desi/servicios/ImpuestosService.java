package tuti.desi.servicios;

import java.util.Optional;
import tuti.desi.entidades.ImpuestosYTasas;
import tuti.desi.excepciones.Excepcion;

public interface ImpuestosService {

	ImpuestosYTasas save(ImpuestosYTasas v) throws Excepcion;

	ImpuestosYTasas getBy_Id(Long id);

	Optional<ImpuestosYTasas> findById(Long id);

}
