package tuti.desi.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
//@NotNull
@Component
public class Vuelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numeroVuelo;
	
	@ManyToOne
	private Ciudad ciudadOrigen; 
	@ManyToOne
	private Ciudad ciudadDestino; 
	
	private String TipoDeVuelo; //nacional o internacional dropdown? precargado
	
	private Double precio;	
	//ZonedDateTime
	private LocalDateTime fechayHora; //clase de errores usa otro
	
	@ManyToOne
	private Avion avion; 

	private String estado = "Normal";
	
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
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
	public String getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(Ciudad ciudadDestino) {
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
	public Vuelo() { // lo creaba con un super() lo borramos tiene que ir o no? lo mismo en ciudad y avion
	}	
	
	
}
