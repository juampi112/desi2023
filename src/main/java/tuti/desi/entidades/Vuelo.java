package tuti.desi.entidades;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@NotNull
@Component
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String numeroVuelo;

	@OneToMany(mappedBy = "vuelo")
	private List<Asiento> asientos = new ArrayList<>(); 
	@ManyToOne
	private Ciudad ciudadOrigen;
	@ManyToOne
	private Ciudad ciudadDestino;

	private String TipoDeVuelo;

	private Double precio;
	// ZonedDateTime

	private Date fechaVuelo;

	private Time horaVuelo;

	@ManyToOne
	private Avion avion;

	private String estado = "Normal";

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}

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

	public Vuelo() {
		//this.asientos = new ArrayList<>();
        //instanciarAsientos();
	}
	
	  public List<Asiento> instanciarAsientos() {
		  
		  List<Asiento>   asientos = new ArrayList<>();
		  	for (int fila = 1; fila <= avion.getCantidadFilas() ; fila++) {
	                for (int columna = 1; columna <= avion.getCantidadAsientos() ; columna++) {
	                    Asiento asiento = new Asiento();
	                    asiento.setNumero(fila + "-" + columna);
	                    asiento.setDisponible(true);
	                    asiento.setVuelo(this); 
	                    asientos.add(asiento);
	                    
	            }
	        }
	  return asientos;
	  
	}}

