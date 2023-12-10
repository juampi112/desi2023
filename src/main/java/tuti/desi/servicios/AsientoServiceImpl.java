package tuti.desi.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IAsientoRepo;
import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;

@Service
public class AsientoServiceImpl implements AsientoService {

	@Autowired
	private IAsientoRepo repo;

	@Override
	public List<Asiento> obtenerAsiento(Long vueloId) throws Excepcion {
		return null ;//repo.findByVueloIdAndDisponible(vueloId);
	}

}
