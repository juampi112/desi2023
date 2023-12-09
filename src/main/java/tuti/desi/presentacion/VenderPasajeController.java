package tuti.desi.presentacion;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tuti.desi.accesoDatos.IAsientoRepo;
import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Cliente;
import tuti.desi.entidades.ConsultaVuelo;
import tuti.desi.entidades.Provincia;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.AsientoService;
import tuti.desi.servicios.AvionService;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.ConsultarVueloService;
import tuti.desi.servicios.ProvinciaService;
import tuti.desi.servicios.VenderPasajeService;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/venderPasaje")
public class VenderPasajeController {
	@Autowired
    private VenderPasajeService servicioVenderPasaje;
	@Autowired
    private AsientoService servicioAsiento;
	@Autowired
	private VueloService servicioVuelo;
	
//	@ModelAttribute("allCiudades")
//	
//	public List<Ciudad> getAllCiudades() {
//		return this.servicioCiudad.getAll();
//	}
   
	
    @RequestMapping(method=RequestMethod.GET) 
    public String preparaForm(Model modelo) {
    	VenderPasajeForm form =  new VenderPasajeForm();
       modelo.addAttribute("formBean",form);
       return "venderPasaje";
    }
     
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit( @ModelAttribute("formBean") @Valid VenderPasajeForm  formBean,BindingResult result, ModelMap modelo,@RequestParam String action) throws Excepcion {
    	
    	if(action.equals("ConsultarCliente"))
    	{  		
    		try {
    			Cliente cliente = servicioVenderPasaje.buscarCliente(formBean); 
    			if(cliente == null) {
    				ObjectError error = new ObjectError("globalError", "Cliente no Registrado. Ingrese un cliente valido");
    				result.addError(error);
    			}
    			else {
    				modelo.addAttribute("esUsuarioRegistrado", true);
    				modelo.addAttribute("resultadoCliente",cliente);}
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", e.getMessage());
	            result.addError(error);
			}
    		
    		modelo.addAttribute("formBean",formBean);
        	return "venderPasaje";
    	}	
    	return "redirect:/";    	
    } 
    
	@ModelAttribute("allVuelos")
	public List<Vuelo> getAllVuelos() {
		return this.servicioVuelo.getAll();
	}    
    

	@ModelAttribute("allAsientosDisponibles")
	public List<Asiento> getAllAsientosDisponibles(@ModelAttribute("formBean") VenderPasajeForm formBean) throws Excepcion {
	
		if (formBean != null) {
	        Vuelo vuelo = formBean.getVueloAConsultar();
	    	System.out.println(vuelo + "hola");//esto siempre es null
	        if (vuelo != null) {
	            return this.servicioAsiento.obtenerAsiento(vuelo.getId());
	        } else {
	            // Manejo de la situación donde vuelo es nulo
	            return Collections.emptyList(); // o null, dependiendo de tus necesidades
	        }
	    } else {
	        // Manejo de la situación donde formBean es nulo
	        return Collections.emptyList(); // o null, dependiendo de tus necesidades
	    }
	}	

	
	
	
    /*    @RequestMapping(method=RequestMethod.GET)
    public String seleccionarAsiento(Model model, @RequestParam Long vueloId) throws Excepcion {
        List<Asiento> asientosDisponibles = servicioAsiento.obtenerAsiento(vueloId);
        model.addAttribute("asientosDisponibles", asientosDisponibles);
        return "venderPasaje";
    }
    
    

  
    
   @RequestMapping(method = RequestMethod.GET)
    public String seleccionarAsiento(Model model, @RequestParam Long vueloId) {
        try {
            List<Asiento> asientosDisponibles = servicioAsiento.obtenerAsiento(vueloId);
            model.addAttribute("asientosDisponibles", asientosDisponibles);
            return "venderPasaje";
        } catch (Excepcion e) {
           
            e.printStackTrace(); 
            return "error"; // Puedes redirigir a una página de error o realizar alguna otra acción adecuada.
        }
    }*/
}
