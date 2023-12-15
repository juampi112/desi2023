package tuti.desi.entidades;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import org.springframework.stereotype.Component;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
@NotNull
@Component
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String numeroVuelo;

	@OneToMany(mappedBy = "vuelo", cascade = CascadeType.PERSIST)
	private List<Asiento> asientos;

	@ManyToOne
	private Ciudad ciudadOrigen;
	@ManyToOne
	private Ciudad ciudadDestino;

	private String TipoDeVuelo;

	private Double precio;

	private Date fechaVuelo;

	private Time horaVuelo;

	@ManyToOne
	private Avion avion;

	private String estado = "Normal";

	private Integer cantAsientosDisp;

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

	public Integer getCantAsientosDisp() {
		return cantAsientosDisp;
	}

	public void setCantAsientosDisp(Integer cantAsientosDisp) {
		this.cantAsientosDisp = cantAsientosDisp;
	}

	public Vuelo() {
	}

}
