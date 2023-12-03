package tuti.desi.presentacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.ConsultaVuelo;
import tuti.desi.entidades.Provincia;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.AvionService;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.ConsultarVueloService;
import tuti.desi.servicios.ProvinciaService;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/consultaVuelo")
public class ConsultarVueloController {
	@Autowired
    private ConsultarVueloService servicioConsultarVuelo;
	@Autowired
	private CiudadService servicioCiudad;
	@Autowired
    private VueloService servicioVuelo;
	
	@ModelAttribute("allCiudades")
	
	public List<Ciudad> getAllCiudades() {
		return this.servicioCiudad.getAll();
	}
   
	
    @RequestMapping(method=RequestMethod.GET) 
    public String preparaForm(Model modelo) {
    	ConsultarVueloForm form =  new ConsultarVueloForm();
       modelo.addAttribute("formBean",form);
       return "consultaVuelo";
    }
     
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit( @ModelAttribute("formBean") @Valid ConsultarVueloForm  formBean,BindingResult result, ModelMap modelo,@RequestParam String action) throws Excepcion {
	
    	if(action.equals("BuscarVuelos"))
    	{  		
    		try {
    			List<Vuelo> vuelos = servicioConsultarVuelo.buscarVuelos(formBean);
    			modelo.addAttribute("resultadosVuelos",vuelos);
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", e.getMessage());
	            result.addError(error);
			}
    		
    		modelo.addAttribute("formBean",formBean);
        	return "consultaVuelo";
    	}	
    	return "redirect:/";    	
    } 
}
