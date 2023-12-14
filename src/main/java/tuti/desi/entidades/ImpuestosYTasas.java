package tuti.desi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Impuestos_Y_Tasas")
@NotNull
public class ImpuestosYTasas {
	@Id
	private Long id = (long) 1;
	private double iva;
	private double tasaAeroportuariaNacional;
	private double tasaAeroportuariaInternacional;
	private double cotizacionDolar;

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTasaAeroportuariaNacional() {
		return tasaAeroportuariaNacional;
	}

	public void setTasaAeroportuariaNacional(double tasaAeroportuariaNacional) {
		this.tasaAeroportuariaNacional = tasaAeroportuariaNacional;
	}

	public double getTasaAeroportuariaInternacional() {
		return tasaAeroportuariaInternacional;
	}

	public void setTasaAeroportuariaInternacional(double tasaAeroportuariaInternacional) {
		this.tasaAeroportuariaInternacional = tasaAeroportuariaInternacional;
	}

	public double getCotizacionDolar() {
		return cotizacionDolar;
	}

	public void setCotizacionDolar(double cotizacionDolar) {
		this.cotizacionDolar = cotizacionDolar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ImpuestosYTasas() {
	}

}
