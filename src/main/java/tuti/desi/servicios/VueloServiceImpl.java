package tuti.desi.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IAsientoRepo;
import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;

@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	private IVueloRepo repo;

	@Autowired
	private IAsientoRepo repoAsiento;

	@Override
	public List<Vuelo> getAll() {

		return repo.findAll();
	}

	@Override
	public Vuelo save(Vuelo v) throws Excepcion {

		return repo.save(v);

	}

	@Override
	public boolean exist(String numVuelo) throws Excepcion {

		return repo.findBynumeroVuelo(numVuelo) != null;
	}

	@Override
	public boolean existVueloRepetido(Avion avion, Date fechaVuelo) throws Excepcion {

		return repo.findByAvionAndfechaVuelo(avion, fechaVuelo) != null;

	}

	@Override
	public void saveVueloConAsientos(Vuelo vuelo) {
		repo.save(vuelo);

		List<Asiento> nuevosAsientos = new ArrayList<>();
		int totalAsientos = vuelo.getAvion().getCapacidad();
		for (int i = 1; i <= totalAsientos; i++) {
			Asiento asiento = new Asiento();
			asiento.setNumero(i);
			asiento.setDisponible(true);
			asiento.setVuelo(vuelo);
			nuevosAsientos.add(asiento);
		}

		for (Asiento asiento : nuevosAsientos) {
			repoAsiento.save(asiento);
		}
	}

}
