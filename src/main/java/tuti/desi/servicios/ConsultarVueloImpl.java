package tuti.desi.servicios;
import java.sql.Date;
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

	/*@Override
	public List<Vuelo> buscarVuelos(ConsultarVueloForm vueloForm) throws Excepcion
	{
		if(vueloForm.getFechaAconsultar()==null )
			throw new Excepcion("Es necesario al menos completar la fecha");
		else
			/*return repo.buscarVuelos(vueloForm.getFechaAconsultar(),vueloForm.getCiudadOrigen_Aconsultar()
					,vueloForm.getCiudadDestino_Aconsultar(),vueloForm.getTipoDeVuelo_Aconsultar());
			return null;
			
				
	}*/
	
	@Override
	public List<ConsultaVuelo> findByParameters(ConsultarVueloForm vueloForm) throws Excepcion {
		if(vueloForm.getFechaAconsultar()==null )
			throw new Excepcion("Es necesario al menos completar la fecha");
		else
			return repo.buscarVuelos(vueloForm.getFechaAconsultar(), vueloForm.getCiudadOrigen_Aconsultar(), vueloForm.getCiudadOrigen_Aconsultar(), vueloForm.getTipoDeVuelo_Aconsultar());
	}
}
