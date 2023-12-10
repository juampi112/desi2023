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
import tuti.desi.entidades.Cliente;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.VenderPasajeService;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/venderPasaje")
public class VenderPasajeController {
	@Autowired
	private VenderPasajeService servicioVenderPasaje;
	@Autowired
	private VueloService servicioVuelo;

	@RequestMapping(method = RequestMethod.GET)
	public String preparaForm(Model modelo) {
		VenderPasajeForm form = new VenderPasajeForm();
		modelo.addAttribute("formBean", form);
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
    				//modelo.addAttribute("esUsuarioRegistrado", true);
    				modelo.addAttribute("resultadoCliente",cliente);}
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", e.getMessage());
	            result.addError(error);
			}
    		
    		modelo.addAttribute("formBean",formBean);
        	return "venderPasaje";
    	}
    	
    	
    	
    	
    	if(action.equals("ConsultarAsiento")) {
    		try {
    			Vuelo vuelo = servicioVenderPasaje.buscarVuelos(formBean); 
    			if(vuelo == null) {
    				ObjectError error = new ObjectError("globalError", "No puede consultar asientos sin seleccionar un vuelo.");
    				result.addError(error);
    			}
    			else {

        			List<Integer> asientos = vuelo.getAsientos();
    				modelo.addAttribute("resultadoVuelo",asientos);

        			System.out.print(asientos);	
    			}
    			
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", e.getMessage());
	            result.addError(error);
			}
    		
    		modelo.addAttribute("formBean",formBean);
        	return null;    		
    		
    	}
    	
    	return "redirect:/";    	
    }

	@ModelAttribute("allVuelos")
	public List<Vuelo> getAllVuelos() {
		return this.servicioVuelo.getAll();
	}

}
