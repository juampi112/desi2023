package tuti.desi.presentacion;
import java.sql.Date;
import java.time.LocalDateTime;
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Vuelo;

/**
 * Objeto necesario para insertar o eliminar una persona. 
 * Nótese que en lugar de referenciar al objeto Ciudad, reemplaza ese atributo por el idCiudad, lo cual resulta mas sencillo de representar en JSON
 *ACA COPIAMOS CUIDADFORM NO SABEMOS MUY BIEN Q ONDA
 */
public class VueloForm {

	private Long id;

	private String numeroVuelo;
	

	private Ciudad ciudadOrigenId; 

	private Ciudad ciudadDestinoId; 
	
	private String TipoDeVuelo; //nacional o internacional dropdown? precargado
	
	private Double precio;	

	private Date fechayHora; //clase de errores usa otro
	
	private Avion avionId; 

	private String estado = "Normal";
	
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
	public Ciudad getCiudadOrigenId() {
		return ciudadOrigenId;
	}
	public void setCiudadOrigenId(Ciudad ciudadOrigenId) {
		this.ciudadOrigenId = ciudadOrigenId;
	}
	public Ciudad getCiudadDestinoId() {
		return ciudadDestinoId;
	}
	public void setCiudadDestinoId(Ciudad ciudadDestinoId) {
		this.ciudadDestinoId = ciudadDestinoId;
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
	public Date getFechayHora() {
		return fechayHora;
	}
	public void setFechayHora(Date fechayHora) {
		this.fechayHora = fechayHora;
	}
	public Avion getAvionId() {
		return avionId;
	}
	public void setAvionId(Avion avionId) {
		this.avionId = avionId;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public VueloForm() {
		super();
	}
	
	
	public Vuelo toPojo()
	{
		Vuelo v = new Vuelo();
		v.setId(this.id);
		v.setNumeroVuelo(this.numeroVuelo);
		v.setCiudadOrigen(this.ciudadOrigenId);
		v.setCiudadDestino(this.ciudadDestinoId);
		v.setTipoDeVuelo(this.TipoDeVuelo);
		v.setPrecio(this.precio);
		v.setFechayHora(this.fechayHora);
		v.setAvion(this.avionId);
		v.setEstado(this.estado);
		return v;
	}
	
	public VueloForm(Vuelo v) {
		super();
		this.id = v.getId();
		this.numeroVuelo = v.getNumeroVuelo();
		this.ciudadOrigenId = v.getCiudadOrigen();
		this.ciudadDestinoId = v.getCiudadDestino();
		TipoDeVuelo = v.getTipoDeVuelo();
		this.precio = v.getPrecio();
		this.fechayHora = v.getFechayHora();
		this.avionId = v.getAvion();
		this.estado = v.getEstado();
	}

	
	
}
