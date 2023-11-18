package tuti.desi.presentacion;

import tuti.desi.entidades.Ciudad;

public class ProgramarVueloForm {
	private String numeroVuelo;	
	private Double precioVuelo;
	public Ciudad ciudadSeleccionadaOrigen;
	public Ciudad ciudadSeleccionadaDestino;
	
	
	public String getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	public Double getPrecioVuelo() {
		return precioVuelo;
	}
	public void setPrecioVuelo(Double precioVuelo) {
		this.precioVuelo = precioVuelo;
	}
	public Ciudad getCiudadSeleccionadaOrigen() {
		return ciudadSeleccionadaOrigen;
	}
	public void setCiudadSeleccionadaOrigen(Ciudad ciudadSeleccionadaOrigen) {
		this.ciudadSeleccionadaOrigen = ciudadSeleccionadaOrigen;
	}
	public Ciudad getCiudadSeleccionadaDestino() {
		return ciudadSeleccionadaDestino;
	}
	public void setCiudadSeleccionadaDestino(Ciudad ciudadSeleccionadaDestino) {
		this.ciudadSeleccionadaDestino = ciudadSeleccionadaDestino;
	}
	
	
	
//	private List<Provincia> provincias;

	
	
//	public List<Provincia> getProvincias() {
//		return provincias;
//	}
//	public void setProvincias(List<Provincia> provincias) {
//		this.provincias = provincias;
//	}
	
//	public Long getProvinciaSeleccionada() {
//		return provinciaSeleccionada;
//	}
//	public void setProvinciaSeleccionada(Long provinciaSeleccionada) {
//		this.provinciaSeleccionada = provinciaSeleccionada;
//	}
//	
//	public String getNombre() {
//		if(nombre!=null && nombre.length()>0)
//			return nombre;
//		else
//			return null;
//	}
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//	
	
	

}
