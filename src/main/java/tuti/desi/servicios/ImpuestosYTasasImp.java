package tuti.desi.servicios;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IImpuestosYTasasRepo;
import tuti.desi.entidades.ImpuestosYTasas;
import tuti.desi.excepciones.Excepcion;

@Service
public class ImpuestosYTasasImp implements ImpuestosService {

	@Autowired
	private IImpuestosYTasasRepo repo;

	@Override
	public ImpuestosYTasas save(ImpuestosYTasas c) throws Excepcion {
		return repo.save(c);

	}

	@Override
	public ImpuestosYTasas getBy_Id(Long id) {
		return repo.findBy_Id(id);
	}

	public Optional<ImpuestosYTasas> findById(Long id) {
		return repo.findById(id);
	}
}
