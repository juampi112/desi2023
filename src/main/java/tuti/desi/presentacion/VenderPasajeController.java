package tuti.desi.presentacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Cliente;
import tuti.desi.entidades.ImpuestosYTasas;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.AsientoService;
import tuti.desi.servicios.ImpuestosService;
import tuti.desi.servicios.VenderPasajeService;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/venderPasaje")
public class VenderPasajeController {
	@Autowired
	private VenderPasajeService servicioVenderPasaje;
	@Autowired
	private VueloService servicioVuelo;
	@Autowired
	private AsientoService servicioAsiento;
	@Autowired
    private ImpuestosService impuestosService;
	
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
    	   	
    	//servicioAsiento
    	if(action.equals("ConsultarAsientoYPrecio")) {
    		
    		//ver de remplazar o usar un metodo de ultima
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
    		try {
    			Vuelo vuelo = servicioVenderPasaje.buscarVuelos(formBean); 
    			if(vuelo == null) {
    				ObjectError error = new ObjectError("globalError", "No puede consultar asientos sin seleccionar un vuelo.");
    				result.addError(error);
    			}
    			else {
    				List<Asiento> asientos = servicioAsiento.obtenerAsiento(vuelo);

    				modelo.addAttribute("resultadoVuelo",asientos);
    			}   			
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", e.getMessage());
	            result.addError(error);
			}
    		
    			
    		modelo.addAttribute("formBean",formBean);

    		Vuelo vuelo = formBean.getVueloAConsultar();
    		
    		Double precio = vuelo.getPrecio(); 
    		boolean esNacional = vuelo.getTipoDeVuelo().equals("nacional");//ver 
    		Double precioTotal = 0.0;		
    		//ImpuestosYTasas impYtas = new ImpuestosYTasas();
    		Optional<ImpuestosYTasas> impYTasas = impuestosService.findById((long) 1);
    		Double iva = impYTasas.get().getIva() / 100;
    		if(esNacional) {
    			Double tasaNac = impYTasas.get().getTasaAeroportuariaNacional();
    			precioTotal = precio + tasaNac + (precio * iva);
 
    		}else {
    			Double tasaInt = impYTasas.get().getTasaAeroportuariaInternacional();
    			Double dolar = impYTasas.get().getCotizacionDolar();
    			
    			precioTotal = precio + (tasaInt * dolar) + (iva * precio);    			
    		}
 		
    		
    		modelo.addAttribute("mostrarPrecio", precioTotal);
        	return "venderPasaje";    		
    		
    	}
	
    	
    	if(action.equals("EmitirTicket"))
    	{  	
    		if (servicioVenderPasaje.buscarCliente(formBean) == null) {
				ObjectError error = new ObjectError("globalError", "Cliente inexistente");
				result.addError(error); 		
    		} else if (formBean.getVueloAConsultar() == null){
				ObjectError error = new ObjectError("globalError", "Vuelo sin seleccionar");
				result.addError(error);		
    		} else if (formBean.getAsientoAConsultar() == null) {
				ObjectError error = new ObjectError("globalError", "Asiento sin consultar");
				result.addError(error);
			} 
			else {	  
				formBean.setDniAConsultar(null);
				formBean.setVueloAConsultar(null);
				
				
				Asiento asiento = formBean.getAsientoAConsultar();
				asiento.setDisponible(false);
				
				servicioAsiento.save(asiento);
				
				modelo.addAttribute("mensaje", "El ticket se emitio correctamente.");	    	   
			}    		
    		 return "venderPasaje";
    	}
    	
    	
    	return "redirect:/";    	
    }

	@ModelAttribute("allVuelos")
	public List<Vuelo> getAllVuelos() {
		return this.servicioVuelo.getAll();
	}

}
