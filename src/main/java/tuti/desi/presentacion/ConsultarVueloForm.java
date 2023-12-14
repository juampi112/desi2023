package tuti.desi.presentacion;

import java.sql.Date;
import tuti.desi.entidades.Ciudad;

public class ConsultarVueloForm {
	private Date fechaAconsultar;
	private Ciudad ciudadOrigen_Aconsultar;
	private Ciudad ciudadDestino_Aconsultar;
	private String tipoDeVuelo_Aconsultar;

	public Date getFechaAconsultar() {
		return fechaAconsultar;
	}

	public void setFechaAconsultar(Date fechaAconsultar) {
		this.fechaAconsultar = fechaAconsultar;
	}

	public Ciudad getCiudadOrigen_Aconsultar() {
		return ciudadOrigen_Aconsultar;
	}

	public void setCiudadOrigen_Aconsultar(Ciudad ciudadOrigen_Aconsultar) {
		this.ciudadOrigen_Aconsultar = ciudadOrigen_Aconsultar;
	}

	public Ciudad getCiudadDestino_Aconsultar() {
		return ciudadDestino_Aconsultar;
	}

	public void setCiudadDestino_Aconsultar(Ciudad ciudadDestino_Aconsultar) {
		this.ciudadDestino_Aconsultar = ciudadDestino_Aconsultar;
	}

	public String getTipoDeVuelo_Aconsultar() {
		return tipoDeVuelo_Aconsultar;
	}

	public void setTipoDeVuelo_Aconsultar(String tipoDeVuelo) {
		this.tipoDeVuelo_Aconsultar = tipoDeVuelo;
	}
}
