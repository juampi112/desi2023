package tuti.desi.servicios;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IConsultarVueloRepo;
import tuti.desi.accesoDatos.IVenderPasajeRepo;
import tuti.desi.entidades.Cliente;
import tuti.desi.entidades.ConsultaVuelo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.ConsultarVueloForm;
import tuti.desi.presentacion.VenderPasajeForm;

@Service
public class VenderPasajeImpl implements VenderPasajeService {

	@Autowired
	IVenderPasajeRepo repo;

	@Override
	public Cliente buscarCliente(VenderPasajeForm venderPasajeForm) throws Excepcion{
		return repo.findBydni(venderPasajeForm.getDniAConsultar());
	}
		
}