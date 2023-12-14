package tuti.desi.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.ICiudadRepo;
import tuti.desi.entidades.Ciudad;

@Service
public class CiudadServiceImpl implements CiudadService {

	@Autowired
	ICiudadRepo repo;

	@Override
	public List<Ciudad> getAll() {

		return repo.findAll();
	}

}
