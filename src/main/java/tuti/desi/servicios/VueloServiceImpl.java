/**
 * @author kuttel
 *
 */
package tuti.desi.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;


@Service
public class VueloServiceImpl implements VueloService {
//	Logger LOG = LoggerFactory.getLogger(CiudadService.class);
//	
	@Autowired
	private IVueloRepo repo;

	



	@Override
	public Vuelo save(Vuelo v) throws Excepcion {
//		if(c.getId()==null && !repo.findByNombreAndIdProvincia(c.getNombre(), c.getProvincia().getId()).isEmpty()) //estoy dando de alta una nueva ciudad y ya existe una igual?
//			throw new Excepcion("Ya existe una ciudad con el mismo nombre, para la misma provincia");  
//		else
			return repo.save(v);
		
	}

}
