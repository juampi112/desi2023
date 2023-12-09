package tuti.desi.presentacion;

import tuti.desi.entidades.Vuelo;

public class VenderPasajeForm {
	private Long dniAConsultar;
	
	private Vuelo vueloAConsultar;
	private Long asientoAConsultar;



	public Vuelo getVueloAConsultar() {
		return vueloAConsultar;
	}

	public void setVueloAConsultar(Vuelo vueloAConsultar) {
		this.vueloAConsultar = vueloAConsultar;
	}

	public Long getAsientoAConsultar() {
		return asientoAConsultar;
	}

	public void setAsientoAConsultar(Long asientoAConsultar) {
		this.asientoAConsultar = asientoAConsultar;
	}

	public Long getDniAConsultar() {
		return dniAConsultar;
	}

	public void setDniAConsultar(Long dniAConsultar) {
		this.dniAConsultar = dniAConsultar;
	}
	


}
