package tuti.desi.presentacion;

import java.sql.Date;

public class ConsultarVueloForm {
	private Date fechaAconsultar;
	private Long ciudadOrigen_Aconsultar;
	private Long ciudadDestino_Aconsultar;
	private String tipoDeVuelo_Aconsultar;

	public Date getFechaAconsultar() {
		return fechaAconsultar;
	}

	public void setFechaAconsultar(Date fechaAconsultar) {
		this.fechaAconsultar = fechaAconsultar;
	}

	public Long getCiudadOrigen_Aconsultar() {
		return ciudadOrigen_Aconsultar;
	}

	public void setCiudadOrigen_Aconsultar(Long ciudadOrigen_Aconsultar) {
		this.ciudadOrigen_Aconsultar = ciudadOrigen_Aconsultar;
	}

	public Long getCiudadDestino_Aconsultar() {
		return ciudadDestino_Aconsultar;
	}

	public void setCiudadDestino_Aconsultar(Long ciudadDestino_Aconsultar) {
		this.ciudadDestino_Aconsultar = ciudadDestino_Aconsultar;
	}

	public String getTipoDeVuelo_Aconsultar() {
		return tipoDeVuelo_Aconsultar;
	}

	public void setTipoDeVuelo_Aconsultar(String tipoDeVuelo) {
		this.tipoDeVuelo_Aconsultar = tipoDeVuelo;
	}
}
