package tuti.desi.presentacion;

import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Vuelo;

public class VenderPasajeForm {
	private Long dniAConsultar;
	
	private Vuelo vueloAConsultar;
	private Asiento asientoAConsultar;



	public Vuelo getVueloAConsultar() {
		return vueloAConsultar;
	}

	public void setVueloAConsultar(Vuelo vueloAConsultar) {
		this.vueloAConsultar = vueloAConsultar;
	}



	public Asiento getAsientoAConsultar() {
		return asientoAConsultar;
	}

	public void setAsientoAConsultar(Asiento asientoAConsultar) {
		this.asientoAConsultar = asientoAConsultar;
	}

	public Long getDniAConsultar() {
		return dniAConsultar;
	}

	public void setDniAConsultar(Long dniAConsultar) {
		this.dniAConsultar = dniAConsultar;
	}
	


}
