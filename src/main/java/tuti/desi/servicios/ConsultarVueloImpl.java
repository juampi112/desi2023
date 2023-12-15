package tuti.desi.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IConsultarVueloRepo;
import tuti.desi.entidades.ConsultaVuelo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.ConsultarVueloForm;

@Service
public class ConsultarVueloImpl implements ConsultarVueloService {

	@Autowired
	IConsultarVueloRepo repo;

	@Override
	public List<Vuelo> buscarVuelos(ConsultarVueloForm vueloForm) throws Excepcion {
		if (vueloForm.getCiudadDestino_Aconsultar() == null && vueloForm.getCiudadOrigen_Aconsultar() == null) {
			return repo.findByfechaVuelo(vueloForm.getFechaAconsultar(), null, null,
					vueloForm.getTipoDeVuelo_Aconsultar());
		}
		if (vueloForm.getCiudadOrigen_Aconsultar() == null) {
			return repo.findByfechaVuelo(vueloForm.getFechaAconsultar(), null, vueloForm.getCiudadDestino_Aconsultar(),
					vueloForm.getTipoDeVuelo_Aconsultar());
		}
		if (vueloForm.getCiudadDestino_Aconsultar() == null) {
			return repo.findByfechaVuelo(vueloForm.getFechaAconsultar(), vueloForm.getCiudadOrigen_Aconsultar(), null,
					vueloForm.getTipoDeVuelo_Aconsultar());
		}

		return repo.findByfechaVuelo(vueloForm.getFechaAconsultar(), vueloForm.getCiudadOrigen_Aconsultar(),
				vueloForm.getCiudadDestino_Aconsultar(), vueloForm.getTipoDeVuelo_Aconsultar());
	}

	@Override
	public List<ConsultaVuelo> findByParameters(ConsultarVueloForm vueloForm) throws Excepcion {
		if (vueloForm.getFechaAconsultar() == null)
			throw new Excepcion("Es necesario al menos completar la fecha");
		else
			return null;
	}
}