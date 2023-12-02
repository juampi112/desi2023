package tuti.desi.entidades;

import java.sql.Date;
import java.sql.Time;


public class ConsultaVuelo {

    private Date fechaVuelo;
	
	private Time horaVuelo;	
	
	private String TipoDeVuelo; 
	
	private String numeroVuelo;
	
	private String estado = "Normal";
	
	private int cantidadDeAsientos;
	public Date getFechaVuelo() {
		return fechaVuelo;
	}
	public void setFechaVuelo(Date fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	public Time getHoraVuelo() {
		return horaVuelo;
	}
	public void setHoraVuelo(Time horaVuelo) {
		this.horaVuelo = horaVuelo;
	}
	public String getTipoDeVuelo() {
		return TipoDeVuelo;
	}
	public void setTipoDeVuelo(String tipoDeVuelo) {
		TipoDeVuelo = tipoDeVuelo;
	}
	public String getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCantidadDeAsientos() {
		return cantidadDeAsientos;
	}
	public void setCantidadDeAsientos(int cantidadDeAsientos) {
		this.cantidadDeAsientos = cantidadDeAsientos;
	}
	
	public ConsultaVuelo() {
	} 
	
}
