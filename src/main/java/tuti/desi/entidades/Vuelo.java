package tuti.desi.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vuelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long numeroVuelo;
	@ManyToOne
	private List<Ciudad> ciudadOrigen; 
	@ManyToOne
	private List<Ciudad> ciudadDestino; 
	
	private String TipoDeVuelo; 
	
	private Double precio;	
	//ZonedDateTime
	private LocalDateTime fechayHora;
	@ManyToOne
	private List<Avion> avion; 

	private String estado = "Normal";
	
	public List<Avion> getAvion() {
		return avion;
	}
	public void setAvion(List<Avion> avion) {
		this.avion = avion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(Long numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	public List<Ciudad> getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(List<Ciudad> ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	public List<Ciudad> getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(List<Ciudad> ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	public String getTipoDeVuelo() {
		return TipoDeVuelo;
	}
	public void setTipoDeVuelo(String tipoDeVuelo) {
		TipoDeVuelo = tipoDeVuelo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public LocalDateTime getFechayHora() {
		return fechayHora;
	}
	public void setFechayHora(LocalDateTime fechayHora) {
		this.fechayHora = fechayHora;
	}	
}
