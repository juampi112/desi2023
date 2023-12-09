package tuti.desi.presentacion;

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
import tuti.desi.entidades.ImpuestosYTasas;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.ImpuestosService;



@Controller
@RequestMapping("/modificarImpuestosYTasas")
public class ModificarImpuestosYTasasController {
	@Autowired
    private ImpuestosService impuestosService;
	
	
    @RequestMapping(method=RequestMethod.GET) 
    public String preparaForm(Model modelo) {
    	ModificarImpuestosYTasasForm form =  new ModificarImpuestosYTasasForm();
       modelo.addAttribute("formBean",form);
       ImpuestosYTasas impYTasas = impuestosService.getBy_Id((long) 1);
       modelo.addAttribute("impYTasas", impYTasas);
       return "modificarImpuestosYTasas";
    }

    @RequestMapping( method=RequestMethod.POST)
    public String submit( @ModelAttribute("formBean") @Valid ModificarImpuestosYTasasForm  formBean,BindingResult result, ModelMap modelo,@RequestParam String action) throws Excepcion {

    	if(action.equals("Modificar")) {
	    		try {

	    			ImpuestosYTasas impuestosYTasas = new ImpuestosYTasas();
	    			impuestosYTasas.setIva(formBean.getIvaSeleccionado());
	    			impuestosYTasas.setTasaAeroportuariaNacional(formBean.getTasaAeroportuariaNacionalSeleccionado());
	    			impuestosYTasas.setTasaAeroportuariaInternacional(formBean.getTasaAeroportuariaInternacionalSeleccionado());
	    			impuestosYTasas.setCotizacionDolar(formBean.getCotizacionDolarSeleccionado());
	    			impuestosService.save(impuestosYTasas);
	    			
	    			return "redirect:/modificarImpuestosYTasas";
	    			
	
				} catch (Exception e) {
					ObjectError error = new ObjectError("globalError", e.getMessage());
		            result.addError(error);
				}
    		}
    		modelo.addAttribute("formBean",formBean);
    		return "modificarImpuestosYTasas";
    	}
    }

