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
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.AvionService;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/programarVuelo")
public class ProgramarVueloController {
	@Autowired
	private CiudadService servicioCiudad;
	@Autowired
	private VueloService vueloService;
	@Autowired
	private AvionService servicioAvion;

	@RequestMapping(method = RequestMethod.GET)
	public String preparaForm(Model modelo) {
		ProgramarVueloForm form = new ProgramarVueloForm();
		modelo.addAttribute("formBean", form);
		return "programarVuelo";
	}

	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {
		return this.servicioCiudad.getAll();
	}

	@ModelAttribute("allAvionesDisponibles")
	public List<Avion> allAvionesDisponibles() {
		return this.servicioAvion.getAll();
	}

	@RequestMapping(method = RequestMethod.POST) // boton submit
	public String submit(@ModelAttribute("formBean") @Valid ProgramarVueloForm formBean, BindingResult result,
			ModelMap modelo, @RequestParam String action) throws Excepcion {

		if (action.equals("Programar")) {
			if (vueloService.exist(formBean.getNumeroVuelo())) {
				ObjectError error = new ObjectError("globalError", "Numero de vuelo repetido");
				result.addError(error);
			} else if (vueloService.existVueloRepetido(formBean.getAvionSeleccionado(),
					formBean.getFechaSeleccionada())) {
				ObjectError error = new ObjectError("globalError", "Ese avion ya tiene asignado vuelo para ese dia");
				result.addError(error);
			} else if (formBean.getCiudadSeleccionadaDestino().equals(formBean.getCiudadSeleccionadaOrigen())) {
				ObjectError error = new ObjectError("globalError", "No puede elegir dos ciudades iguales");
				result.addError(error);
			} else {
				try {

					Vuelo vuelo = new Vuelo();
					vuelo.setNumeroVuelo(formBean.getNumeroVuelo());
					vuelo.setPrecio(formBean.getPrecioVuelo());
					vuelo.setCiudadDestino(formBean.getCiudadSeleccionadaDestino());
					vuelo.setCiudadOrigen(formBean.getCiudadSeleccionadaOrigen());
					vuelo.setTipoDeVuelo(formBean.getTipoDeVueloSeleccionado());
					vuelo.setAvion(formBean.getAvionSeleccionado());
					vuelo.setFechaVuelo(formBean.getFechaSeleccionada());
					vuelo.setHoraVuelo(formBean.getHoraVuelo());
					vuelo.setAsientos(vuelo.instanciarAsientos());
					vueloService.save(vuelo);
					return "redirect:/programarVuelo";

				} catch (Exception e) {
					ObjectError error = new ObjectError("globalError", e.getMessage());
					result.addError(error);
				}
			}
			modelo.addAttribute("formBean", formBean);
			return "programarVuelo";
		}
		return "redirect:/";

	}

}
