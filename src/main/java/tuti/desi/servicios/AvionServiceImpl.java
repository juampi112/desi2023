package tuti.desi.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IAvionRepo;
import tuti.desi.entidades.Avion;

@Service
public class AvionServiceImpl implements AvionService {

	@Autowired
	IAvionRepo repo;

	@Override
	public List<Avion> getAll() {
		return repo.findAll();

	}

}
