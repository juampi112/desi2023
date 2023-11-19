package tuti.desi.presentacion;

import java.sql.Date;
import java.sql.Time;

import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;

public class ProgramarVueloForm {
	private String numeroVuelo;	
	private Double precioVuelo;
	private Ciudad ciudadSeleccionadaOrigen;
	private Ciudad ciudadSeleccionadaDestino;
	private String tipoDeVueloSeleccionado;
	private Date fechaYHoraSeleccionada;
	private Avion avionSeleccionado;
	private Time horaVuelo;
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
	public String getTipoDeVueloSeleccionado() {
		return tipoDeVueloSeleccionado;
	}
	public void setTipoDeVueloSeleccionado(String tipoDeVueloSeleccionado) {
		this.tipoDeVueloSeleccionado = tipoDeVueloSeleccionado;
	}

	public Date getFechaYHoraSeleccionada() {
		return fechaYHoraSeleccionada;
	}
	public void setFechaYHoraSeleccionada(Date fechaYHoraSeleccionada) {
		this.fechaYHoraSeleccionada = fechaYHoraSeleccionada;
	}
	public Avion getAvionSeleccionado() {
		return avionSeleccionado;
	}
	public void setAvionSeleccionado(Avion avionSeleccionado) {
		this.avionSeleccionado = avionSeleccionado;
	}
	public Time getHoraVuelo() {
		return horaVuelo;
	}
	public void setHoraVuelo(Time horaVuelo) {
		this.horaVuelo = horaVuelo;
	}

}
