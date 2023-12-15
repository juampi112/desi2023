package tuti.desi.excepciones;

public class Excepcion extends Exception{


	private  String atributo;
	
	public Excepcion() {
		super();
		
	}

	public Excepcion(String mensaje) {
		super(mensaje);
	}

	public Excepcion(String mensaje, String atributo) {
		super(mensaje);
		this.atributo=atributo;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
}