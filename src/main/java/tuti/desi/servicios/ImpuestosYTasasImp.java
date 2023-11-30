package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.ICiudadRepo;
import tuti.desi.accesoDatos.IImpuestosYTasasRepo;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.ImpuestosYTasas;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.CiudadesBuscarForm;

@Service
public class ImpuestosYTasasImp implements ImpuestosService {

	@Autowired
	private IImpuestosYTasasRepo repo;

	@Override
	public ImpuestosYTasas save(ImpuestosYTasas c) throws Excepcion {
		return repo.save(c);
		
	}

	@Override
	public ImpuestosYTasas getById(Long id) {
		return repo.findById(id).get();
	}





}
